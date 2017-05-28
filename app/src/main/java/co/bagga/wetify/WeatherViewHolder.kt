package co.bagga.wetify

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import co.bagga.wetify.Models.WeatherList

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var icon: ImageView = itemView.findViewById(R.id.icon) as ImageView
    var temp: TextView = itemView.findViewById(R.id.temperature) as TextView
    var time: TextView = itemView.findViewById(R.id.time) as TextView

    fun updateView(weather: WeatherList) {
        temp.text = weather.dt.toString()
        time.text = weather.main?.pressure.toString()
    }
}