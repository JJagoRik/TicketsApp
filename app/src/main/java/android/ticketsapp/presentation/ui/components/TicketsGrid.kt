package android.ticketsapp.presentation.ui.components

import android.ticketsapp.domain.model.Ticket
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun TicketsGrid(tickets: List<Ticket>){
    LazyRow(
        contentPadding = PaddingValues(4.dp)
    ){
        itemsIndexed(tickets) { _, ticket ->
            TicketCell(ticket = ticket)
        }
    }
}