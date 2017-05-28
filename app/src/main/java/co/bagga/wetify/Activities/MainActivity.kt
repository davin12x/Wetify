package co.bagga.wetify.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import co.bagga.wetify.Adapter.WeatherAdapter
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Network.RequestGenerator
import co.bagga.wetify.R
import co.bagga.wetify.Utils.JsonParser

class MainActivity : AppCompatActivity() {
    val TAG: String = javaClass.simpleName
    val weatherAdapter: WeatherAdapter = WeatherAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0f

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = weatherAdapter

        fetchWeatherDataByName("Kitchener", RequestGenerator.getInstance(applicationContext))
    }

    fun fetchWeatherDataByName(cityName: String, requestGenerator: RequestGenerator) {
        requestGenerator.generateFetchWeatherForecastByNameHttpRequest(cityName, object: HttpCallBack {
            override fun onHttpRequestSuccess(response: String, responseCode: Int) {
                val weatherList = JsonParser.parseJsonWeatherList(response)
                weatherAdapter.refreshData(weatherList)
            }

            override fun onHttpRequestError(response: String, responseCode: Int) {
                Log.e(TAG, response)
            }
        } )
    }
}
