package co.bagga.wetify.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import co.bagga.wetify.Network.MyVolley
import co.bagga.wetify.R
import co.bagga.wetify.Utils.UrlBuilder
import com.android.volley.Request
import com.android.volley.Response
import org.json.JSONObject
import com.android.volley.toolbox.JsonObjectRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = UrlBuilder.buildForeCastUrlByName("Kitchener");

        val jsObjRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener<JSONObject> { response -> Log.e("bla", response.toString()) },
                Response.ErrorListener { error -> print(error) })

        MyVolley.getInstance(applicationContext).addToRequestQueue(jsObjRequest)
    }
}
