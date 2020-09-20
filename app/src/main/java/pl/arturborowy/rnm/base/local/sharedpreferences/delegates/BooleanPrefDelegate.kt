package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class BooleanPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: Boolean,
    override val prefKey: String? = null
) : PrefDelegate<Boolean> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getBoolean(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) =
        prefs.putBoolean(prefKey ?: property.name, value)

    private fun SharedPreferences.putBoolean(key: String, value: Boolean) =
            edit().putBoolean(key, value).apply()
}