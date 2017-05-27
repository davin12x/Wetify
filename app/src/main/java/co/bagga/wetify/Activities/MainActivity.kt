package co.bagga.wetify.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Network.RequestGenerator
import co.bagga.wetify.R
import co.bagga.wetify.Utils.JsonParser

class MainActivity : AppCompatActivity() {
    val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchWeatherDataByName(RequestGenerator.getInstance(applicationContext))

    }

    fun fetchWeatherDataByName(requestGenerator: RequestGenerator) {
        requestGenerator.generateFetchWeatherForecastByNameHttpRequest("Kitchener", object: HttpCallBack {
            override fun onHttpRequestSuccess(response: String, responseCode: Int) {
                var weatherList = JsonParser.parseJsonWeatherList(response)

            }

            override fun onHttpRequestError(response: String, responseCode: Int) {
                Log.e(TAG, response)
            }
        } )
    }
}
