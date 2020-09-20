package pl.arturborowy.rnm.domain.stations

import io.reactivex.Completable
import io.reactivex.Single
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

interface StationsLocalRepository {

    fun getKeywords(): Single<List<KeywordEntity>>

    fun setKeywords(keywords: List<KeywordEntity>): Completable

    fun getStations(): Single<List<StationEntity>>

    fun setStations(stations: List<StationEntity>): Completable
}