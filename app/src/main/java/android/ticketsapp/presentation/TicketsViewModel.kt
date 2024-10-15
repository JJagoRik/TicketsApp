package android.ticketsapp.presentation

import android.content.Context
import android.ticketsapp.R
import android.ticketsapp.data.parseJson
import android.ticketsapp.data.readJsonFromRaw
import android.ticketsapp.domain.model.GalleryItem
import android.ticketsapp.domain.model.Ticket
import android.ticketsapp.domain.repository.PhotosFlickrRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch

class TicketsViewModel(
    private val ticketsRepository: PhotosFlickrRepository,
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
            _offersPic.value = ticketsRepository.getPhotos()
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
                val ticketsRepository = application.container.photosFlickrRepository
                TicketsViewModel(ticketsRepository = ticketsRepository, applicationContext = application.applicationContext)
            }
        }
    }
}