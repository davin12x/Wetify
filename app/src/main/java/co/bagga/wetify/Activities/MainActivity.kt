package co.bagga.wetify.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.bagga.wetify.Interface.HttpCallBack
import co.bagga.wetify.Network.RequestGenerator
import co.bagga.wetify.R

class MainActivity : AppCompatActivity() {
    val TAG: String = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val requestGenerator = RequestGenerator.getInstance(applicationContext)
        requestGenerator.generateFetchWeatherForecastByNameHttpRequest("Kitchener", object: HttpCallBack {
            override fun onHttpRequestSuccess(response: String, responseCode: Int) {
                Log.e(TAG, response)
            }

            override fun onHttpRequestError(response: String, responseCode: Int) {
                Log.e(TAG, response)
            }
        } )
    }
}
