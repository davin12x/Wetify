package co.bagga.wetify.Utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

/**
 * Created by Lalit Bagga on 2017-06-18.
 */

class SharedPreference private constructor(context: Context) {
    private var sharedPreferences: SharedPreferences? = null
    private var sharedPrefCityListKey = "sharedPrefCityListKey"

    init {
        sharedPreferences = context.getSharedPreferences(javaClass.simpleName, Context.MODE_PRIVATE)
    }

    companion object {
        private var instance : SharedPreference? = null

        fun  getInstance(context: Context): SharedPreference {
            if (instance == null) {
                instance = SharedPreference(context)
            }
            return instance!!
        }
    }

    fun saveWeatherCityList(city: String) {
        val editor = sharedPreferences?.edit()
        var cityList = ""
        val newCityList = ArrayList<String>()
        if (getSavedCityList() != null) {
            for (cityName in getSavedCityList()!!) {
                newCityList.add(cityName)
            }
            newCityList.add(city)
            cityList  = Gson().toJson(newCityList)
        } else {
            cityList = city
        }
        editor?.putString(sharedPrefCityListKey, cityList)
        editor?.apply();
    }

    fun getSavedCityList(): List<String>? {
        return sharedPreferences?.getString(sharedPrefCityListKey, null)?.split(",")
    }
}
