package co.bagga.wetify.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.bagga.wetify.Models.WeatherData
import co.bagga.wetify.R
import co.bagga.wetify.Utils.FilterWeatherDataByDay
import co.bagga.wetify.WeatherViewHolder

/**
 * Created by Lalit Bagga on 2017-05-27.
 *
 * Adapter used to show list of weather of various cities
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    internal var data: ArrayList<WeatherData>

    init {
        data = ArrayList<WeatherData>()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, p1: Int): WeatherViewHolder {
        return WeatherViewHolder(LayoutInflater.from(viewGroup?.context).inflate(R.layout.weather_item_row, viewGroup, false))
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherList = data[position]
        holder.updateView(weatherList, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(data: WeatherData) {
        this.data.add(data)
        notifyItemChanged(this.data.size)
    }
}