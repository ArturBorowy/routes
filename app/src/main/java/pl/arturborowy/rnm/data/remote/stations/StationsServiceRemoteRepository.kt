package pl.arturborowy.rnm.data.remote.stations

import pl.arturborowy.rnm.data.remote.StationsService
import pl.arturborowy.rnm.data.remote.stations.mapper.KeywordDtoToEntityMapper
import pl.arturborowy.rnm.data.remote.stations.mapper.StationDtoToEntityMapper
import pl.arturborowy.rnm.domain.stations.StationsRemoteRepository

class StationsServiceRemoteRepository(
    private val stationsService: StationsService,
    private val keywordDtoToEntityMapper: KeywordDtoToEntityMapper,
    private val stationDtoToEntityMapper: StationDtoToEntityMapper
) : StationsRemoteRepository {

    override fun getStations() =
        stationsService.getStations()
            .map { stations ->
                stations.map { station -> stationDtoToEntityMapper.map(station) }
            }

    override fun getKeywords() =
        stationsService.getKeywords()
            .map { keywords ->
                keywords.map { keyword -> keywordDtoToEntityMapper.map(keyword) }
            }
}