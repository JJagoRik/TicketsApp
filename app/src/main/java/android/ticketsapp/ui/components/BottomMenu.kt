package android.ticketsapp.ui.components

import android.ticketsapp.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun BottomMenu(){
    Row(
        modifier = Modifier
            .requiredHeight(52.dp)
    ) {
        BottomMenuCell(R.drawable.avia_tickets, "Авиабилеты")
        BottomMenuCell(R.drawable.hotels, "Отели")
        BottomMenuCell(R.drawable.map, "Карта")
        BottomMenuCell(R.drawable.notifications, "Уведомления")
        BottomMenuCell(R.drawable.profile, "Профиль")
    }
}