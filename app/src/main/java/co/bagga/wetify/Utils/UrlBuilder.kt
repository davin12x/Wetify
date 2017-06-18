package co.bagga.wetify.Utils

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

class UrlBuilder {
    companion object {
        fun buildFiveDaysForeCastUrlByName(cityName: String): String {
            return Constants.Companion.BASE_OPEN_WEATHER_API + Constants.Companion.FORECAST + "q=" + cityName + "&" + Constants.Companion.API_KEY
        }

        fun buildCurrentTimeForeCastUrlByName(cityName: String): String {
            return Constants.Companion.BASE_OPEN_WEATHER_API + "weather?q=" + cityName + "&" + Constants.Companion.API_KEY + "&units=metric"
        }
    }
}
