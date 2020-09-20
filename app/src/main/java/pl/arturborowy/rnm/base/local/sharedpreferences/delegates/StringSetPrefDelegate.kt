package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class StringSetPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: Set<String>,
    override val prefKey: String? = null
) : PrefDelegate<Set<String>?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Set<String>? =
        prefs.getStringSet(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Set<String>?) =
        prefs.putStringSet(prefKey ?: property.name, value)

    private fun SharedPreferences.putStringSet(key: String, value: Set<String>?) =
        edit().putStringSet(key, value).apply()
}