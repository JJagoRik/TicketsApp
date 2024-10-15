package android.ticketsapp.presentation

import android.app.Application
import android.ticketsapp.data.api.RetrofitClient

class TicketsApplication : Application() {
    lateinit var container: RetrofitClient
    override fun onCreate() {
        super.onCreate()
        container = RetrofitClient()
    }
}