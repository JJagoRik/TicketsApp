package android.ticketsapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun RowScope.BottomMenuCell(image: Int, description: String){
    Box(
        modifier = Modifier
            .weight(1f)
            .clickable { }
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Box(
                modifier = Modifier
                    .requiredHeight(44.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = image,
                        builder = {
                            decoderFactory(SvgDecoder.Factory())
                        }
                    ),
                    contentDescription = description,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onBackground
                ),
                 modifier = Modifier
                     .align(Alignment.CenterHorizontally)
            )
        }
    }
}