package co.bagga.wetify.Network

import co.bagga.wetify.Interface.HttpCallBack
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONObject

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

object JsonRequest {
    fun generateJsonObjectRequest(URL: String, httpCallBack: HttpCallBack): JsonObjectRequest {
        return JsonObjectRequest(Request.Method.GET, URL, null,
                Response.Listener<JSONObject> { response -> httpCallBack.onHttpRequestSuccess(response.toString(), 200) },
                Response.ErrorListener { error ->
                    var errorCode = 400
                    if (error.networkResponse != null) {
                        errorCode = error.networkResponse.statusCode
                    }
                    httpCallBack.onHttpRequestError(error.toString(), errorCode)
                })
    }
}
