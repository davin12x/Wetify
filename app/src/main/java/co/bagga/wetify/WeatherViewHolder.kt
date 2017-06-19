package co.bagga.wetify

import android.graphics.Color
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

    fun updateView(weather: WeatherData, holderPosition:Int) {
        countryTextView.text = weather.sys?.country
        cityTextView.text = weather.name
        temp.text = weather.main?.temp?.let { RoundNumber.roundToClosestNumber(it).toString() + "\u00B0" }
        humidity.text = weather.main?.humidity?.let { RoundNumber.roundToClosestNumber(it).toString() + "%" }
        val calendar =  TimeUtil.getCalendar(weather.dt)
        time.text = calendar.get(Calendar.HOUR_OF_DAY).toString() + ":" +calendar.get(Calendar.MINUTE)

        if (holderPosition == 0) {
            toggleViewColour(true)
            rootLayout.setCardBackgroundColor(Color.WHITE)
        } else{
            toggleViewColour(false)
            val colours = itemView.resources.getIntArray(R.array.card_colors)
            if (holderPosition > colours.size) {
                val rnd = Random()
                val  colour = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                rootLayout.setCardBackgroundColor(colour)
            } else {
                rootLayout.setCardBackgroundColor(colours[holderPosition - 1])
            }
        }
    }

    private fun toggleViewColour(isDarKView:Boolean) {
        if (isDarKView) {
            countryTextView.setTextColor(Color.BLACK)
            cityTextView.setTextColor(Color.BLACK)
            temp.setTextColor(Color.BLACK)
            time.setTextColor(Color.BLACK)
            humidity.setTextColor(Color.BLACK)
        } else{
            countryTextView.setTextColor(Color.WHITE)
            cityTextView.setTextColor(Color.WHITE)
            temp.setTextColor(Color.WHITE)
            time.setTextColor(Color.WHITE)
            humidity.setTextColor(Color.WHITE)
        }
    }
}