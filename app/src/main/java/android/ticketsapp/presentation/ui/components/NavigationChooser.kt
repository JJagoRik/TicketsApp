package android.ticketsapp.presentation.ui.components

import android.ticketsapp.R
import android.ticketsapp.presentation.ui.theme.LightGrey
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.decode.SvgDecoder

@Composable
fun NavigationChooser(textFrom: TextFieldValue,
                      textTo: TextFieldValue,
                      onTextFromChange: (TextFieldValue) -> Unit,
                      onTextToChange: (TextFieldValue) -> Unit,
                      onCleanText: () -> Unit,
                      onSwapText: () -> Unit){
    Box(
        modifier = Modifier
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color.Black,
                spotColor = Color.Black,
            )
            .clip(RoundedCornerShape(20.dp))
            .background(color = LightGrey)
            .requiredWidth(380.dp)
            .requiredHeight(120.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.plane,
                        builder = {
                            decoderFactory(SvgDecoder.Factory())
                        }
                    ),
                    contentDescription = "Самолёт",
                    modifier = Modifier
                        .requiredSize(30.dp)
                )
                Box(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    BasicTextField(
                        value = textFrom,
                        onValueChange = onTextFromChange,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        ),
                        cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.White),
                    )
                    if (textFrom.text.isEmpty()) {
                        Text(
                            text = "Откуда - Москва",
                            style = TextStyle(color = Color.Gray)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(120.dp))
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.change,
                        builder = {
                            decoderFactory(SvgDecoder.Factory())
                        }
                    ),
                    contentDescription = "Свапер",
                    modifier = Modifier
                        .requiredSize(22.dp)
                        .clickable {
                            onSwapText()
                        }
                )
            }

            Divider(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(0.8f),
                color = Color.White,
                thickness = 1.dp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
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
                        .requiredSize(30.dp)
                )
                Box(
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    BasicTextField(
                        value = textTo,
                        onValueChange = onTextToChange,
                        textStyle = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp
                        ),
                        cursorBrush = androidx.compose.ui.graphics.SolidColor(Color.White),
                    )
                    if (textTo.text.isEmpty()) {
                        Text(
                            text = "Куда - Минск",
                            style = TextStyle(color = Color.Gray)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(120.dp))
                Image(
                    painter = rememberImagePainter(
                        data = R.drawable.close,
                        builder = {
                            decoderFactory(SvgDecoder.Factory())
                        }
                    ),
                    contentDescription = "Поиск",
                    modifier = Modifier
                        .requiredSize(22.dp)
                        .clickable {
                            onCleanText()
                        }
                )
            }
        }
    }
}