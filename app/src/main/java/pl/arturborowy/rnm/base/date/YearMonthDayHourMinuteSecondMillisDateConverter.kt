package pl.arturborowy.rnm.base.date

import java.text.SimpleDateFormat
import java.util.*

class YearMonthDayHourMinuteSecondMillisDateConverter(locale: Locale) : DateConverter {

    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSS'Z'", locale)

    override fun convert(string: String) = simpleDateFormat.parse(string)!!

    override fun convert(date: Date) = simpleDateFormat.format(date)
}