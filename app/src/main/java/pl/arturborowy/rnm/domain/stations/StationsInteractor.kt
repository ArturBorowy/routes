package pl.arturborowy.rnm.domain.stations

import io.reactivex.rxkotlin.zipWith
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsInteractor(private val stationsRemoteRepository: StationsRemoteRepository) {

    fun getStationsAndKeywords() =
        stationsRemoteRepository.getStations()
            .zipWith(stationsRemoteRepository.getKeywords())
            .map { (stations, keywords) ->
                stations to filterKeywordsWithoutMatchingStation(keywords, stations)
            }

    private fun filterKeywordsWithoutMatchingStation(
        keyWords: List<KeywordEntity>,
        stations: List<StationEntity>
    ) =
        keyWords.filter { keyword -> hasMatchingStation(keyword, stations) }

    private fun hasMatchingStation(keyword: KeywordEntity, stations: List<StationEntity>) =
        stations.any { station -> station.id == keyword.stationId }
}