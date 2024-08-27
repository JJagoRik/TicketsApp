package android.ticketsapp.data.ticketsData

import android.ticketsapp.network.api.TicketsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface TicketsContainer {
    val ticketsRepository: TicketsRepository
}

class TicketsAppContainer : TicketsContainer {
    private val BASE_URL = "https://api.flickr.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: TicketsApi by lazy {
        retrofit.create(TicketsApi::class.java)
    }

    override val ticketsRepository: TicketsRepository by lazy {
        TicketsNetworkRepository(retrofitService)
    }
}