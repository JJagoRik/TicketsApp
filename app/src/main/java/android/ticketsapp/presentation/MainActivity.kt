package android.ticketsapp.presentation

import android.os.Bundle
import android.ticketsapp.presentation.ui.screens.MainScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MainScreen()
        }
    }
}