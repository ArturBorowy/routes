package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class IntPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: Int,
    override val prefKey: String? = null
) : PrefDelegate<Int> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getInt(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) =
        prefs.putInt(prefKey ?: property.name, value)

    private fun SharedPreferences.putInt(key: String, value: Int) =
            edit().putInt(key, value).apply()
}