package pl.arturborowy.rnm.data.local.stations.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.arturborowy.rnm.data.local.stations.cache.model.KeywordDb
import pl.arturborowy.rnm.data.local.stations.cache.model.StationDb

@Database(entities = arrayOf(KeywordDb::class, StationDb::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun keywordsDao(): KeywordsDao
    abstract fun stationsDao(): StationsDao
}