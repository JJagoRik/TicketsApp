package android.ticketsapp.ui.components

import android.ticketsapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun RowScope.BottomMenuCell(image: Int, description: String){
    Box(
        modifier = Modifier
            .weight(1f)
            .clickable { }
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
}