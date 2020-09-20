package pl.arturborowy.rnm.base.di

import org.koin.dsl.module
import pl.arturborowy.rnm.data.local.stations.cache.mapper.KeywordDbToEntityMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.KeywordEntityToDbMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.StationDbToEntityMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.StationEntityToDbMapper
import pl.arturborowy.rnm.data.remote.stations.mapper.KeywordDtoToEntityMapper
import pl.arturborowy.rnm.data.remote.stations.mapper.StationDtoToEntityMapper

val mapperModule = module {
    single { KeywordDtoToEntityMapper() }
    single { StationDtoToEntityMapper() }

    single { StationEntityToDbMapper() }
    single { StationDbToEntityMapper() }
    single { KeywordDbToEntityMapper() }
    single { KeywordEntityToDbMapper() }
}