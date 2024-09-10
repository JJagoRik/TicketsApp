package android.ticketsapp.ui.components

import android.ticketsapp.R
import android.ticketsapp.data.ticketsData.Ticket
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.decode.SvgDecoder

@Composable
fun TicketCell(
    ticket: Ticket,
){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .requiredHeight(270.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        onClick = {}
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .requiredSize(160.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(ticket.imageUrl)
                        .build(),
                    contentDescription = stringResource(id = R.string.title),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = ticket.title ?: stringResource(id = R.string.error_description),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 20.sp
                    )
                )
                Text(text = ticket.town ?: stringResource(id = R.string.error_description))
                Row {
                    Image(
                        painter = rememberImagePainter(
                            data = R.drawable.avia_tickets,
                            builder = {
                                decoderFactory(SvgDecoder.Factory())
                            }
                        ),
                        contentDescription = "ticket",
                        modifier = Modifier
                            .requiredSize(34.dp)
                            .fillMaxSize()
                            .padding(4.dp)
                    )
                    Text(
                        text = "от " + ticket.price.toString() + " ₽",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}