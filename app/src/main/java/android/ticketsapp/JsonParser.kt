package android.ticketsapp

import android.content.Context
import android.ticketsapp.network.models.Offer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

fun readJsonFromRaw(context: Context, rawResourceId: Int): String {
    val inputStream = context.resources.openRawResource(rawResourceId)
    val reader = InputStreamReader(inputStream)
    val json = reader.readText()
    reader.close()
    inputStream.close()
    return json
}

fun parseJson(json: String): Offer {
    val gson = Gson()
    val type = object : TypeToken<Offer>() {}.type
    return  gson.fromJson(json, type)
}