package android.ticketsapp.ui.screens

import android.ticketsapp.R
import android.ticketsapp.TicketsViewModel
import android.ticketsapp.ui.components.TicketsGrid
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(){
    val booksViewModel: TicketsViewModel = viewModel(factory = TicketsViewModel.Factory)
    val tickets by booksViewModel.offersInfo.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 50.dp)
                .requiredHeight(100.dp)
                .requiredWidth(200.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
        ){
            Text(
                text = "Поиск дешёвых авиабилетов",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(color = Color(R.color.grey))
                .requiredWidth(350.dp)
                .requiredHeight(150.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Color(R.color.light_grey))
                    .requiredWidth(300.dp)
                    .requiredHeight(100.dp)
                    .align(Alignment.Center)
            )
        }

        Text(
            text = "Лучшие билеты",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp)
        )

        TicketsGrid(tickets = tickets)
    }

}