package android.ticketsapp.ui.screens

import android.ticketsapp.ui.components.BottomMenu
import android.ticketsapp.ui.theme.TicketsAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(){
    TicketsAppTheme {
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
}