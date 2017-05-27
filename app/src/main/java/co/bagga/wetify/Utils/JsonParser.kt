package co.bagga.wetify.Utils

import com.google.gson.Gson

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

import co.bagga.wetify.Models.WeatherList

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

object JsonParser {

    fun parseJsonWeatherList(result: String): ArrayList<WeatherList> {
        val weatherList = ArrayList<WeatherList>()
        val list: JSONArray
        val jsonObject: JSONObject
        try {
            jsonObject = JSONObject(result)
            list = jsonObject.getJSONArray("list")
            for (i in 0..list.length() - 1) {
                val `object` = list.getJSONObject(i)
                weatherList.add(Gson().fromJson(`object`.toString(), WeatherList::class.java))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return weatherList
    }
}
