package co.bagga.wetify.Utils

import android.util.Log
import java.text.DateFormatSymbols
import java.util.*

/**
 * Created by Lalit Bagga on 2017-05-28.
 */

object TimeUtil {

    fun getDayOfMonth(seconds: Long): Int {
        return getCalendar(seconds).get(Calendar.DAY_OF_MONTH)
    }

    fun monthInString(seconds: Long): String {
        return getCalendar(seconds).getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH )
    }

    fun getCalendar(seconds: Long): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeZone = TimeZone.getDefault()
        calendar.timeInMillis = seconds * 1000
        return calendar
    }
}
