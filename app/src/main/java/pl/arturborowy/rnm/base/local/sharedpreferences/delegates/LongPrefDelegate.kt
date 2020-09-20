package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class LongPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: Long,
    override val prefKey: String? = null
) : PrefDelegate<Long> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getLong(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) =
        prefs.putLong(prefKey ?: property.name, value)

    private fun SharedPreferences.putLong(key: String, value: Long) =
            edit().putLong(key, value).apply()
}