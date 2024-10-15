package android.ticketsapp.data.api

import android.ticketsapp.data.repository.PhotosFlickrRepositoryImpl
import android.ticketsapp.domain.PreparationContainer
import android.ticketsapp.domain.repository.PhotosFlickrRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient : PreparationContainer {
    private val BASE_URL = "https://api.flickr.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: PhotosFlickrApi by lazy {
        retrofit.create(PhotosFlickrApi::class.java)
    }

    override val photosFlickrRepository: PhotosFlickrRepository by lazy {
        PhotosFlickrRepositoryImpl(retrofitService)
    }
}