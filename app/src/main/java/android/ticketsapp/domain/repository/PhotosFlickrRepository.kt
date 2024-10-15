package android.ticketsapp.domain.repository

import android.ticketsapp.domain.model.GalleryItem

interface PhotosFlickrRepository {
    suspend fun getPhotos() : List<GalleryItem>?
}