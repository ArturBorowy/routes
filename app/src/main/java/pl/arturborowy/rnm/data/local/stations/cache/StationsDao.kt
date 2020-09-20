package pl.arturborowy.rnm.data.local.stations.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.arturborowy.rnm.data.local.stations.cache.model.StationDb

@Dao
interface StationsDao {

    @Query("SELECT * FROM stationdb")
    fun getAll(): List<StationDb>

    @Insert
    fun insertAll(stations: List<StationDb>)
}