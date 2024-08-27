package android.ticketsapp.data.ticketsData

import android.ticketsapp.network.flickrData.GalleryItem
import android.ticketsapp.network.api.TicketsApi

interface TicketsRepository {
    suspend fun getTickets() : List<GalleryItem>?
}

class TicketsNetworkRepository(
    private val ticketsApi: TicketsApi
) : TicketsRepository {
    override suspend fun getTickets(): List<GalleryItem>? =
        ticketsApi.ticketsSearch().photos?.photo?.map { items ->
            GalleryItem(
                title = items.title,
                id = items.id,
                url = items.urlS,
                owner = items.owner
            )
        }
}