package android.ticketsapp.ui.screens

import android.ticketsapp.ui.components.BottomMenu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen(){
    Scaffold(
        bottomBar = {
            BottomMenu()
        },
        modifier = Modifier,
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                HomeScreen()
            }
        }
    )

}