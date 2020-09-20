package pl.arturborowy.rnm.domain.stations

import io.reactivex.Single
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

interface StationsRemoteRepository {

    fun getStations(): Single<List<StationEntity>>

    fun getKeywords(): Single<List<KeywordEntity>>
}