package android.ticketsapp.network.api

import android.ticketsapp.network.models.Offer
import com.example.example.Flickr
import retrofit2.http.GET

private const val API_KEY = "743f3bb7cc99494d7b541eefb53cf2c3"

interface TicketsApi {
    @GET("services/rest/?method=flickr.interestingness.getList" +
            "&api_key=$API_KEY" +
            "&format=json" +
            "&nojsoncallback=1" +
            "&extras=url_s")
    suspend fun ticketsSearch() : Flickr
}