package android.ticketsapp.ui.screens

import android.ticketsapp.ui.components.BottomMenu
import android.ticketsapp.ui.theme.TicketsAppTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen(){
    val systemUiController = rememberSystemUiController()
    var backgroundColor = MaterialTheme.colorScheme.onBackground

    SideEffect {
        systemUiController.setStatusBarColor(
            color = backgroundColor
        )
    }

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