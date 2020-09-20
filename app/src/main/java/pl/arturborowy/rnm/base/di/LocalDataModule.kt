package pl.arturborowy.rnm.base.di

import androidx.room.Room
import org.koin.dsl.module
import pl.arturborowy.rnm.base.local.sharedpreferences.SharedPreferencesRepository
import pl.arturborowy.rnm.data.local.stations.cache.AppDatabase

val localDataModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "database-app").build() }

    single { SharedPreferencesRepository(get(), "sp-main") }
}