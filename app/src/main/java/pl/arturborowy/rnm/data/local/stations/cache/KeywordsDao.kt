package pl.arturborowy.rnm.data.local.stations.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import pl.arturborowy.rnm.data.local.stations.cache.model.KeywordDb
import pl.arturborowy.rnm.domain.stations.model.StationEntity

@Dao
interface KeywordsDao {

    @Query("SELECT * FROM keywords")
    fun getAll(): List<KeywordDb>

    @Insert
    fun insertAll(stations: List<KeywordDb>)
}