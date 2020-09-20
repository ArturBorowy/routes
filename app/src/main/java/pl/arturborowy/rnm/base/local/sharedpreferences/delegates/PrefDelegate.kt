package pl.arturborowy.rnm.base.local.sharedpreferences.delegates

import kotlin.properties.ReadWriteProperty

interface PrefDelegate<ValueT> : ReadWriteProperty<Any?, ValueT> {

    val prefKey: String?
}