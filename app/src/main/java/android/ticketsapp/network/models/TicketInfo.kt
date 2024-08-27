package android.ticketsapp.network.models

data class TicketInfo(
    val id: Int? = null,
    val title: String? = null,
    val town: String? = null,
    val price: Price? = Price()
)