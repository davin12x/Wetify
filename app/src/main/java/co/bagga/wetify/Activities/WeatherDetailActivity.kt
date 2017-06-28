package co.bagga.wetify.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.TextView
import co.bagga.wetify.Adapter.WeatherDayAdapter
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Models.WeatherData
import co.bagga.wetify.Network.RequestGenerator
import co.bagga.wetify.R
import co.bagga.wetify.Utils.JsonParser
import java.lang.RuntimeException

class WeatherDetailActivity : AppCompatActivity() {

    var foreCastRecyclerView: RecyclerView ?= null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)

        if (!intent.hasExtra(applicationContext.getString(R.string.weather_data_model))) {
            throw RuntimeException("Must pass weather data")
        }

        val currentTemperature = findViewById(R.id.current_tempearture) as TextView
        val cityTextView = findViewById(R.id.city) as TextView
        foreCastRecyclerView = findViewById(R.id.detail_recycler_view) as RecyclerView
        foreCastRecyclerView!!.layoutManager = LinearLayoutManager(this)

        val weatherData = intent.getSerializableExtra(applicationContext.getString(R.string.weather_data_model)) as WeatherData
        currentTemperature.text = weatherData.main?.temp.toString()
        cityTextView.text = weatherData.name

        fetchForeCastData(weatherData, RequestGenerator.getInstance(applicationContext))
    }

    private fun fetchForeCastData(weatherData: WeatherData, requestGenerator: RequestGenerator) {
        requestGenerator.fetchFutureDaysForecastByNameHttpRequest(weatherData.name!!, object : HttpCallBack {
            override fun onHttpRequestSuccess(response: String, responseCode: Int) {
                val weatherData = JsonParser.parseJsonWeatherList(response)
                foreCastRecyclerView!!.adapter = WeatherDayAdapter(weatherData);
            }

            override fun onHttpRequestError(response: String, responseCode: Int) {
            }
        })
    }
}
