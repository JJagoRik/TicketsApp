package android.ticketsapp.presentation.ui.components

import android.ticketsapp.R
import android.ticketsapp.presentation.ui.theme.LightGrey
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun Recomendations(){
    Box(
        modifier = Modifier.shadow(
            elevation = 8.dp,
            shape = RoundedCornerShape(20.dp),
            ambientColor = Color.Black,
            spotColor = Color.Black,
        )
            .clip(RoundedCornerShape(20.dp))
            .background(color = LightGrey)
            .requiredWidth(380.dp)
            .wrapContentHeight(),
    ) {
        Column {
            Row {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.close,
                        builder = {
                            decoderFactory(SvgDecoder.Factory())
                        }
                    ),
                    contentDescription = "",
                    modifier = Modifier
                        .requiredSize(22.dp)
                )
                Text(text = "Стамбул")
            }
        }
    }
}