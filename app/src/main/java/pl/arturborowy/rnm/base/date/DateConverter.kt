package pl.arturborowy.rnm.base.date

import java.util.*

interface DateConverter {

    fun convert(string: String): Date

    fun convert(date: Date): String
}