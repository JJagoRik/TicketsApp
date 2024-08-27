package android.ticketsapp.ui.screens

import android.ticketsapp.R
import android.ticketsapp.TicketsViewModel
import android.ticketsapp.ui.components.TicketsGrid
import android.ticketsapp.ui.theme.Grey
import android.ticketsapp.ui.theme.LightGrey
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun HomeScreen(){
    val booksViewModel: TicketsViewModel = viewModel(factory = TicketsViewModel.Factory)
    val tickets by booksViewModel.offersInfo.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .background(color = LightGrey)
                .requiredWidth(380.dp)
                .requiredHeight(150.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp, // Уровень тени
                        shape = RoundedCornerShape(20.dp), // Форма тени
                        ambientColor = Color.Black, // Цвет тени
                        spotColor = Color.Black, // Цвет тени
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Grey)
                    .requiredWidth(340.dp)
                    .requiredHeight(110.dp)
                    .align(Alignment.Center)
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.Center)
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = R.drawable.search,
                            builder = {
                                decoderFactory(SvgDecoder.Factory())
                            }
                        ),
                        contentDescription = "Поиск",
                        modifier = Modifier
                            .requiredSize(40.dp)
                    )

                    Box(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(1f)
                    ) {
                        Column {
                            Text(
                                text = "Минск"
                            )

                            Divider(
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .fillMaxWidth(0.8f), // Ширина полоски
                                color = Color.White, // Цвет полоски
                                thickness = 1.dp // Толщина полоски
                            )

                            Text(
                                text = "Москва"
                            )
                        }
                    }
                }
            }
        }

        Text(
            text = "Лучшие билеты",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier
                .padding(start = 30.dp, top = 30.dp)
        )

        TicketsGrid(tickets = tickets)
    }
}