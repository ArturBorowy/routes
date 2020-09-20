package pl.arturborowy.rnm.base.local.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import pl.arturborowy.rnm.base.local.sharedpreferences.delegates.*

/**
 * Represents a single [SharedPreferences] file.
 *
 * Usage example in SharedPreferencesSettingsRepository.kt
 */
class SharedPreferencesRepository(context: Context, fileName: String) {

    private val prefs by lazy {
        context.getSharedPreferences(fileName, Context.MODE_PRIVATE)
    }

    fun stringPref(defaultValue: String? = null, prefKey: String? = null) =
        StringPrefDelegate(prefs, defaultValue, prefKey)

    fun intPref(defaultValue: Int = 0, prefKey: String? = null) =
        IntPrefDelegate(prefs, defaultValue, prefKey)

    fun floatPref(defaultValue: Float = 0f, prefKey: String? = null) =
        FloatPrefDelegate(prefs, defaultValue, prefKey)

    fun booleanPref(defaultValue: Boolean = false, prefKey: String? = null) =
        BooleanPrefDelegate(prefs, defaultValue, prefKey)

    fun longPref(defaultValue: Long = 0L, prefKey: String? = null) =
        LongPrefDelegate(prefs, defaultValue, prefKey)

    fun stringSetPref(defaultValue: Set<String> = HashSet(), prefKey: String? = null) =
        StringSetPrefDelegate(prefs, defaultValue, prefKey)
}