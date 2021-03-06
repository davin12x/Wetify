package co.bagga.wetify.Models

import java.io.Serializable

class WeatherData: Serializable {
    var coordinates: Coordinates? = null
    var main: Main? = null
    var wind: Wind? = null
    var dt: Long = 0
    var name: String? = null
    var dt_txt: String? = null
    var sys: Sys? = null
}
