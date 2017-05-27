package co.bagga.wetify.Utils

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

class UrlBuilder {
    companion object {
        fun buildForeCastUrlByName(cityName: String): String {
            return Constants.Companion.BASE_OPEN_WEATHER_API + "q=" + cityName + "&" + Constants.Companion.API_KEY
        }
    }
}
