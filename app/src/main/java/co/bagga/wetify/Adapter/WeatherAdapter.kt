package co.bagga.wetify.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import co.bagga.wetify.Models.WeatherList
import co.bagga.wetify.R
import co.bagga.wetify.WeatherViewHolder

/**
 * Created by Lalit Bagga on 2017-05-27.
 */
class WeatherAdapter : RecyclerView.Adapter<WeatherViewHolder>() {

    internal var data: ArrayList<WeatherList>

    init {
       data = ArrayList<WeatherList>()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup?, p1: Int): WeatherViewHolder {
        val itemView = LayoutInflater.from(viewGroup?.context).inflate(R.layout.weather_item_row, viewGroup, false)
        return WeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weatherList = data.get(position)
        holder.updateView(weatherList)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(data: ArrayList<WeatherList>) {
        this.data = data
        notifyDataSetChanged()
    }
}