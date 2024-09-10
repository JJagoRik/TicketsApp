package android.ticketsapp.ui.components

import android.graphics.Paint.Align
import android.ticketsapp.R
import android.ticketsapp.ui.theme.DarkGreen
import android.ticketsapp.ui.theme.LightGrey
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun IconCell(image: Int, iconColor: Color, description: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .requiredWidth(78.dp)
            .requiredHeight(120.dp)
            .clickable { },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = iconColor)
                    .requiredSize(60.dp),
                contentAlignment = Alignment.Center
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
                        .padding(15.dp)
                        .fillMaxSize()
                        .align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier.padding(top = 8.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground,
                        lineHeight = 16.sp
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
@Preview
private fun IconCellTest(){
    IconCell(image = R.drawable.path, iconColor = DarkGreen, description = "Выходные")
}