package pl.arturborowy.rnm.base.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.arturborowy.rnm.base.date.YearMonthDayHourMinuteSecondMillisDateConverter
import pl.arturborowy.rnm.data.local.stations.cache.StationsRoomRepository
import pl.arturborowy.rnm.data.local.stations.cache.meta.StationsCacheMetadataSpRepository
import pl.arturborowy.rnm.data.remote.stations.StationsServiceRemoteRepository
import pl.arturborowy.rnm.domain.stations.StationsLocalRepository
import pl.arturborowy.rnm.domain.stations.StationsRemoteRepository
import pl.arturborowy.rnm.domain.stations.meta.StationsCacheMetadataLocalRepository

val repositoryModule = module {
    single<StationsRemoteRepository> { StationsServiceRemoteRepository(get(), get(), get()) }
    single<StationsLocalRepository> { StationsRoomRepository(get(), get(), get(), get(), get()) }
    single<StationsCacheMetadataLocalRepository> {
        StationsCacheMetadataSpRepository(
            get(),
            get(named<YearMonthDayHourMinuteSecondMillisDateConverter>())
        )
    }
}