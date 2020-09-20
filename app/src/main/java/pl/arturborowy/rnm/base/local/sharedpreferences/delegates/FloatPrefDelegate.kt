package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.PrefDelegate
import kotlin.reflect.KProperty

class FloatPrefDelegate(
    private val prefs: SharedPreferences,
    private val defaultValue: Float,
    override val prefKey: String? = null
) : PrefDelegate<Float> {

    override fun getValue(thisRef: Any?, property: KProperty<*>) =
            prefs.getFloat(prefKey ?: property.name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Float) =
        prefs.putFloat(prefKey ?: property.name, value)

    private fun SharedPreferences.putFloat(key: String, value: Float) =
            edit().putFloat(key, value).apply()
}