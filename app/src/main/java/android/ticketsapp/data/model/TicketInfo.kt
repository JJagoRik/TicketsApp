package android.ticketsapp.data.model

data class TicketInfo(
    val id: Int? = null,
    val title: String? = null,
    val town: String? = null,
    val price: Price? = Price()
)