package android.ticketsapp

import android.content.Context
import android.ticketsapp.network.flickrData.GalleryItem
import android.ticketsapp.data.ticketsData.Ticket
import android.ticketsapp.data.ticketsData.TicketsRepository
import android.ticketsapp.network.models.Offer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.io.InputStream
import java.io.InputStreamReader

class TicketsViewModel(
    private val ticketsRepository: TicketsRepository,
    private val applicationContext: Context
) : ViewModel() {

    private val _offersPic = MutableLiveData<List<GalleryItem>>()
    private val offersPic: LiveData<List<GalleryItem>> = _offersPic

    private val _offersInfo = MutableLiveData<List<Ticket>>()
    val offersInfo: LiveData<List<Ticket>> = _offersInfo

    init {
        getTickets()
    }

    fun getTickets() {
        viewModelScope.launch {
            _offersPic.value = ticketsRepository.getTickets()
            loadTicketsFromJson()
        }
    }

    fun loadTicketsFromJson() {
        viewModelScope.launch {
            try {
                val json = readJsonFromRaw(applicationContext, R.raw.offers)
                Log.d("TicketsViewModel", "JSON loaded: $json")
                val offer = parseJson(json)
                val tickets = offer.offers.map { ticketInfo ->
                    Ticket(
                        id = ticketInfo.id,
                        title = ticketInfo.title,
                        town = ticketInfo.town,
                        price = ticketInfo.price?.value
                    )
                }
                _offersInfo.value = tickets
                matchTicketsWithGalleryItems(tickets)
            } catch (e: Exception) {
                Log.e("TicketsViewModel", "Error loading tickets from JSON", e)
            }
        }
    }

    private fun matchTicketsWithGalleryItems(tickets: List<Ticket>) {
        val galleryItems = offersPic.value ?: emptyList()
        if (galleryItems.isEmpty()) {
            Log.e("TicketsViewModel", "GalleryItems is empty")
            return
        }
        val matchedTickets = tickets.mapIndexed { index, ticket ->
            val galleryItem = galleryItems.getOrNull(index % galleryItems.size)
            ticket.copy(imageUrl = galleryItem?.url)
        }
        _offersInfo.value = matchedTickets
    }

    private fun matchCitiesWithPics(){
        val galleryItems = offersPic.value

    }

    companion object {
        val Factory:ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as TicketsApplication)
                val ticketsRepository = application.container.ticketsRepository
                TicketsViewModel(ticketsRepository = ticketsRepository, applicationContext = application.applicationContext)
            }
        }
    }
}