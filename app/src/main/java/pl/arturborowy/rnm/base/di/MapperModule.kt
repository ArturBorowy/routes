package pl.arturborowy.rnm.base.di

import org.koin.dsl.module
import pl.arturborowy.rnm.data.remote.stations.mapper.KeywordDtoToEntityMapper
import pl.arturborowy.rnm.data.remote.stations.mapper.StationDtoToEntityMapper

val mapperModule = module {
    single { KeywordDtoToEntityMapper() }
    single { StationDtoToEntityMapper() }
}