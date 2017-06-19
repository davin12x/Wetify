package co.bagga.wetify.Activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import co.bagga.wetify.Adapter.WeatherAdapter
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Network.RequestGenerator
import co.bagga.wetify.R
import co.bagga.wetify.Utils.JsonParser
import co.bagga.wetify.Utils.SharedPreference

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    val TAG: String = javaClass.simpleName
    val weatherAdapter: WeatherAdapter = WeatherAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.elevation = 0f

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val addCityButton = findViewById(R.id.floatingActionButton) as FloatingActionButton
        addCityButton.setOnClickListener(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = weatherAdapter

        val cityList = SharedPreference.getInstance(applicationContext).getSavedCityList()
        if (cityList != null) {
            for (citName in cityList) {
                fetchWeatherDataByName(citName, RequestGenerator.getInstance(applicationContext))
            }
        }
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SearchActivity::class.java);
        startActivity(intent);
    }

    fun fetchWeatherDataByName(cityName: String, requestGenerator: RequestGenerator) {
        requestGenerator.generateFetchWeatherForecastByNameHttpRequest(cityName, object: HttpCallBack {
            override fun onHttpRequestSuccess(response: String, responseCode: Int) {

                val weatherData = JsonParser.parseCurrentWeather(response)
                weatherAdapter.refreshData(weatherData)
            }

            override fun onHttpRequestError(response: String, responseCode: Int) {
                Log.e(TAG, response)
            }
        } )
    }
}
