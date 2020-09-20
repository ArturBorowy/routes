package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class StringPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: String?,
    override val prefKey: String? = null
) : PrefDelegate<String?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): String? =
            prefs.getString(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) =
        prefs.putString(prefKey ?: property.name, value)

    private fun SharedPreferences.putString(key: String, value: String?) =
            edit().putString(key, value).apply()
}