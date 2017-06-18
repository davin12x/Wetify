package co.bagga.wetify

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import co.bagga.wetify.Models.WeatherList
import co.bagga.wetify.Utils.TimeUtil
import java.sql.Time

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var icon: ImageView = itemView.findViewById(R.id.icon) as ImageView
    var temp: TextView = itemView.findViewById(R.id.temperature) as TextView
    var time: TextView = itemView.findViewById(R.id.minTemp) as TextView
    var rootLayout: ConstraintLayout = itemView.findViewById(R.id.rootView) as ConstraintLayout

    fun updateView(weather: WeatherList) {
        val dayOfMonth = TimeUtil.getDayOfMonth(weather.dt)
        temp.text = TimeUtil.monthInString(weather.dt) + dayOfMonth
        time.text = weather.main?.pressure.toString()
    }

    fun toggleRootLayout(isVisible: Boolean) {
        if (isVisible) {
            rootLayout.visibility = View.VISIBLE
        } else{
            rootLayout.visibility = View.GONE
        }
    }
}