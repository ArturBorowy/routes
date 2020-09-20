package pl.arturborowy.rnm.domain.stations

import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsInteractor(
    private val stationsRemoteRepository: StationsRemoteRepository,
    private val distanceCounter: DistanceCounter,
    private val stationsCacheInteractor: StationsCacheInteractor
) {

    fun getStationsAndKeywords() =
        stationsRemoteRepository.getStations()
            .zipWith(stationsRemoteRepository.getKeywords())
            .map { (stations, keywords) ->
                sort(stations) to filterKeywordsWithoutMatchingStation(keywords, stations)
            }
            .flatMap { (stations, keywords) ->
                stationsCacheInteractor.setStations(stations).andThen(
                    stationsCacheInteractor.setKeywords(keywords)
                ).andThen(Single.just(stations to keywords))
            }
            .onErrorResumeNext(
                stationsCacheInteractor.getStations()
                    .zipWith(stationsCacheInteractor.getKeywords())
            )

    private fun sort(stations: List<StationEntity>) =
        stations.sortedByDescending { it.hits }

    private fun filterKeywordsWithoutMatchingStation(
        keyWords: List<KeywordEntity>,
        stations: List<StationEntity>
    ) =
        keyWords.filter { keyword -> hasMatchingStation(keyword, stations) }

    private fun hasMatchingStation(keyword: KeywordEntity, stations: List<StationEntity>) =
        stations.any { station -> station.id == keyword.stationId }

    fun getDistance(departure: StationEntity, destination: StationEntity) =
        distanceCounter.betweenPointsOnSphere(
            departure.latitude!!,
            departure.longitude!!,
            destination.latitude!!,
            destination.longitude!!
        )
}