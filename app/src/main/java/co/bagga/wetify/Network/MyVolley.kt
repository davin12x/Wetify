package co.bagga.wetify.Network

import android.content.Context
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class MyVolley private constructor(applicationContext: Context?){

    private var mRequestQueue: RequestQueue? = null

    companion object {
        private var instance : MyVolley? = null

        fun  getInstance(context: Context): MyVolley {
            if (instance == null) {
                instance = MyVolley(context)
            }
            return instance!!
        }
    }

    init {
        mRequestQueue = Volley.newRequestQueue(applicationContext)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        mRequestQueue!!.add(req)
    }
}