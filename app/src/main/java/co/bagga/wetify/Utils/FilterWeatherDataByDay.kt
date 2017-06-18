package co.bagga.wetify.Utils

import co.bagga.wetify.Models.WeatherData

/**
 * Created by Lalit Bagga on 2017-05-28.
 */
object FilterWeatherDataByDay {

    fun filterData(data: ArrayList<WeatherData>) : ArrayList<WeatherData> {
        val dataList = ArrayList<WeatherData>()
        for (i in data.indices) {
            if (data.size - 1 != i && TimeUtil.getDayOfMonth(data[i].dt) != TimeUtil.getDayOfMonth(data[i + 1].dt)) {
                dataList.add(data[i])
            }
        }
        return dataList
    }
}