package pl.arturborowy.rnm.data.local.stations.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StationDb(
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "hits")
    val hits: Int,
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "localised_name")
    val localisedName: String? = null,
    @ColumnInfo(name = "latitude")
    val latitude: Double? = null,
    @ColumnInfo(name = "longitude")
    val longitude: Double? = null
)