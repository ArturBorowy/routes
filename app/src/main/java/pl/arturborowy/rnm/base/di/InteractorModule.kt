package pl.arturborowy.rnm.base.di

import org.koin.dsl.module
import pl.arturborowy.rnm.domain.stations.StationsCacheInteractor
import pl.arturborowy.rnm.domain.stations.StationsInteractor

val interactorModule = module {
    single { StationsInteractor(get(), get(), get()) }
    single { StationsCacheInteractor(get(), get()) }
}