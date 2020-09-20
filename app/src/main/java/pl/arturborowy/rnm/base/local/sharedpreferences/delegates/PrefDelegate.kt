package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import kotlin.reflect.KProperty

interface PrefDelegate<ValueT> {

    val prefKey: String?

    operator fun getValue(thisRef: Any?, property: KProperty<*>): ValueT

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: ValueT)
}