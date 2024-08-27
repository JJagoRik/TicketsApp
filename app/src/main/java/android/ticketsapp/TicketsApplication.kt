package android.ticketsapp

import android.app.Application
import android.ticketsapp.data.ticketsData.TicketsAppContainer
import android.ticketsapp.data.ticketsData.TicketsContainer

class TicketsApplication : Application() {
    lateinit var container: TicketsContainer
    override fun onCreate() {
        super.onCreate()
        container = TicketsAppContainer()
    }
}