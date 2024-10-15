package android.ticketsapp.domain.model

data class Ticket(
    val id: Int? = null,
    val title: String? = null,
    val town: String? = null,
    val price: Int? = null,
    val imageUrl: String? = null
)