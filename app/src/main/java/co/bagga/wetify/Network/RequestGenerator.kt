package co.bagga.wetify.Network

import android.content.Context
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Utils.UrlBuilder

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class RequestGenerator private constructor(applicationContext: Context){
    private var mApplicationContext: Context? = null

    companion object {
        private var ourInstance: RequestGenerator? = null

        fun getInstance(applicationContext: Context): RequestGenerator {
            if (ourInstance == null) {
                ourInstance = RequestGenerator(applicationContext)
            }
            return ourInstance!!
        }
    }

    init {
        this.mApplicationContext = applicationContext;
    }

    fun fetchCurrentWeatherForecastByNameHttpRequest(cityName: String, httpCallBack: HttpCallBack) {
        val URL = UrlBuilder.buildCurrentTimeForeCastUrlByName(cityName)
        return MyVolley.getInstance(mApplicationContext!!)
                .addToRequestQueue(JsonRequest.generateJsonObjectRequest(URL, httpCallBack))
    }

    fun fetchFutureDaysForecastByNameHttpRequest(cityName: String, httpCallBack: HttpCallBack) {
        val URL = UrlBuilder.buildFiveDaysForeCastUrlByName(cityName)
        return MyVolley.getInstance(mApplicationContext!!)
                .addToRequestQueue(JsonRequest.generateJsonObjectRequest(URL, httpCallBack))
    }
}