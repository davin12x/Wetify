package co.bagga.wetify

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import co.bagga.wetify.Models.WeatherData
import co.bagga.wetify.Utils.RoundNumber
import co.bagga.wetify.Utils.TimeUtil
import java.util.*

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var icon: ImageView = itemView.findViewById(R.id.icon) as ImageView
    var cityTextView : TextView = itemView.findViewById(R.id.cityName) as TextView
    var countryTextView : TextView = itemView.findViewById(R.id.countryName) as TextView
    var temp: TextView = itemView.findViewById(R.id.currentTemperature) as TextView
    var time: TextView = itemView.findViewById(R.id.time) as TextView
    var humidity : TextView = itemView.findViewById(R.id.humidity) as TextView
    var rootLayout: CardView = itemView.findViewById(R.id.rootView) as CardView

    fun updateView(weather: WeatherData) {
        countryTextView.text = weather.sys?.country
        cityTextView.text = weather.name
        temp.text = weather.main?.temp?.let { RoundNumber.roundToClosestNumber(it).toString() + "\u00B0" }
        humidity.text = weather.main?.humidity?.let { RoundNumber.roundToClosestNumber(it).toString() + "%" }
        val calendar =  TimeUtil.getCalendar(weather.dt)
        time.text = calendar.get(Calendar.HOUR_OF_DAY).toString() + ":" +calendar.get(Calendar.MINUTE)
    }
}