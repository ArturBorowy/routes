package pl.arturborowy.rnm.base.di

import org.koin.dsl.module
import pl.arturborowy.rnm.data.local.stations.cache.StationsRoomRepository
import pl.arturborowy.rnm.data.remote.stations.StationsServiceRemoteRepository
import pl.arturborowy.rnm.domain.stations.StationsLocalRepository
import pl.arturborowy.rnm.domain.stations.StationsRemoteRepository

val repositoryModule = module {
    single<StationsRemoteRepository> { StationsServiceRemoteRepository(get(), get(), get()) }
    single<StationsLocalRepository> { StationsRoomRepository(get(), get(), get(), get(), get()) }
}