package pl.arturborowy.rnm.domain.stations

import io.reactivex.Completable
import io.reactivex.Single
import pl.arturborowy.rnm.domain.stations.meta.StationsCacheMetadataLocalRepository
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity
import java.util.*

class StationsCacheInteractor(
    private val stationsLocalRepository: StationsLocalRepository,
    private val stationsCacheMetadataLocalRepository: StationsCacheMetadataLocalRepository
) {

    companion object {
        private const val MILLISECONDS_IN_DAY = 1000 * 60 * 60 * 24
    }

    private val currentTime
        get() = Date()

    fun getKeywords(): Single<List<KeywordEntity>> {
        return runIfCacheIsNotObsolete(stationsLocalRepository.getKeywords())
    }

    private fun <ValueT> runIfCacheIsNotObsolete(runIf: Single<ValueT>): Single<ValueT> {
        return Single.create<ValueT> { emitter ->
            if(isCacheOlderThanOneDay()) {
                emitter.onError(CacheException())
            } else {
                emitter.onSuccess(runIf.blockingGet())
            }
        }
    }

    private fun isCacheOlderThanOneDay() =
        currentTime.time - stationsCacheMetadataLocalRepository.cacheCreationTime?.time!! >
                MILLISECONDS_IN_DAY

    fun setKeywords(keywords: List<KeywordEntity>): Completable {
        setCurrentTimeOfCacheSave()
        return stationsLocalRepository.setKeywords(keywords)
    }

    private fun setCurrentTimeOfCacheSave() {
        stationsCacheMetadataLocalRepository.cacheCreationTime = currentTime
    }

    fun getStations(): Single<List<StationEntity>> {
        return runIfCacheIsNotObsolete(stationsLocalRepository.getStations())
    }

    fun setStations(stations: List<StationEntity>): Completable {
        setCurrentTimeOfCacheSave()
        return stationsLocalRepository.setStations(stations)
    }
}

class CacheException : Exception("Cache is too old!")