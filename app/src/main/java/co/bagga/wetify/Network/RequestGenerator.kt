package co.bagga.wetify.Network

import android.content.Context
import android.util.Log
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

    fun generateFetchWeatherForecastByNameHttpRequest(cityName: String, httpCallBack: HttpCallBack) {
        val URL = UrlBuilder.buildForeCastUrlByName(cityName)
        Log.e("bla", URL )
        return MyVolley.getInstance(mApplicationContext!!)
                .addToRequestQueue(JsonRequest.generateJsonObjectRequest(URL, httpCallBack))
    }
}