package android.ticketsapp.domain

import android.ticketsapp.domain.repository.PhotosFlickrRepository

interface PreparationContainer {
    val photosFlickrRepository: PhotosFlickrRepository
}