package co.bagga.wetify.Utils

import com.google.gson.Gson

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

import java.util.ArrayList

import co.bagga.wetify.Models.WeatherData

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

object JsonParser {

    fun parseJsonWeatherList(result: String): ArrayList<WeatherData> {
        val weatherList = ArrayList<WeatherData>()
        val list: JSONArray
        val jsonObject: JSONObject
        try {
            jsonObject = JSONObject(result)
            list = jsonObject.getJSONArray("list")
            for (i in 0..list.length() - 1) {
                val `object` = list.getJSONObject(i)
                weatherList.add(Gson().fromJson(`object`.toString(), WeatherData::class.java))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return weatherList
    }

    fun parseCurrentWeather(result: String): WeatherData {
        val jsonObject: JSONObject
        try {
            jsonObject = JSONObject(result)
            return Gson().fromJson(jsonObject.toString(), WeatherData::class.java)
        } catch (e: JSONException) {
            e.printStackTrace()
            return WeatherData()
        }
    }
}
