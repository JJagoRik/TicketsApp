package android.ticketsapp.presentation.ui.screens

import android.ticketsapp.R
import android.ticketsapp.presentation.TicketsViewModel
import android.ticketsapp.presentation.ui.components.IconCell
import android.ticketsapp.presentation.ui.components.NavigationChooser
import android.ticketsapp.presentation.ui.components.TicketsGrid
import android.ticketsapp.presentation.ui.theme.DarkBlue
import android.ticketsapp.presentation.ui.theme.DarkGreen
import android.ticketsapp.presentation.ui.theme.Grey
import android.ticketsapp.presentation.ui.theme.LightBlue
import android.ticketsapp.presentation.ui.theme.LightGrey
import android.ticketsapp.presentation.ui.theme.LightRed
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val booksViewModel: TicketsViewModel = viewModel(factory = TicketsViewModel.Factory)
    val tickets by booksViewModel.offersInfo.observeAsState(emptyList())
    var textFrom by remember { mutableStateOf(TextFieldValue("")) }
    var textTo by remember { mutableStateOf(TextFieldValue("")) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberBottomSheetScaffoldState()

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
                        elevation = 8.dp,
                        shape = RoundedCornerShape(20.dp),
                        ambientColor = Color.Black,
                        spotColor = Color.Black,
                    )
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = Grey)
                    .requiredWidth(340.dp)
                    .requiredHeight(110.dp)
                    .align(Alignment.Center)
                    .clickable {
                        showBottomSheet = true
                    }
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .align(Alignment.Center),
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
                            .align(Alignment.CenterVertically)
                    )

                    Box(
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .weight(1f)
                    ) {
                        Column {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                BasicTextField(
                                    value = textFrom,
                                    onValueChange = { newText ->
                                        textFrom = newText
                                    },
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.White),
                                    enabled = false
                                )
                                if (textFrom.text.isEmpty()) {
                                    Text(
                                        text = "Откуда - Москва",
                                        style = TextStyle(color = Color.Gray)
                                    )
                                }
                            }

                            Divider(
                                modifier = Modifier
                                    .padding(vertical = 8.dp)
                                    .fillMaxWidth(0.8f),
                                color = Color.White,
                                thickness = 1.dp
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                            ) {
                                BasicTextField(
                                    value = textTo,
                                    onValueChange = { newText ->
                                        textTo = newText
                                    },
                                    textStyle = TextStyle(
                                        color = Color.White,
                                        fontSize = 16.sp
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.White),
                                    enabled = false
                                )
                                if (textTo.text.isEmpty()) {
                                    Text(
                                        text = "Куда - Минск",
                                        style = TextStyle(color = Color.Gray),
                                    )
                                }
                            }
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

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false }
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    Column {
                        NavigationChooser(
                            textFrom = textFrom,
                            textTo = textTo,
                            onTextFromChange = { textFrom = it },
                            onTextToChange = { textTo = it },
                            onCleanText = { textTo = TextFieldValue("") },
                            onSwapText = { textFrom = textTo.also { textTo = textFrom } })
                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 30.dp, bottom = 60.dp)
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(20.dp)
                            ) {
                                IconCell(image = R.drawable.path, iconColor = DarkGreen, description = "Сложный маршрут")
                                IconCell(image = R.drawable.sphere, iconColor = LightBlue, description = "Куда угодно")
                                IconCell(image = R.drawable.calendar, iconColor = DarkBlue, description = "Выходные")
                                IconCell(image = R.drawable.fire, iconColor = LightRed, description = "Горячие билеты")
                            }
                        }

                    }
                }
            }
        }
    }
}