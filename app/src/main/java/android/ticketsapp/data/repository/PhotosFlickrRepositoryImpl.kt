package android.ticketsapp.data.repository

import android.ticketsapp.data.api.PhotosFlickrApi
import android.ticketsapp.domain.model.GalleryItem
import android.ticketsapp.domain.repository.PhotosFlickrRepository

class PhotosFlickrRepositoryImpl(
    private val photosFlickrApi: PhotosFlickrApi
) : PhotosFlickrRepository {
    override suspend fun getPhotos(): List<GalleryItem>? =
        photosFlickrApi.ticketsSearch().photos?.photo?.map { items ->
            GalleryItem(
                title = items.title,
                id = items.id,
                url = items.urlS,
                owner = items.owner
            )
        }
}