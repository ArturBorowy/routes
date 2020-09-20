package pl.arturborowy.rnm.data.local.stations.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class KeywordDb(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "keyword")
    val keyword: String,
    @ColumnInfo(name = "station_id")
    val stationId: Long
)