package pl.arturborowy.rnm.data.local.stations.cache

import io.reactivex.Completable
import io.reactivex.Single
import pl.arturborowy.rnm.data.local.stations.cache.mapper.KeywordDbToEntityMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.KeywordEntityToDbMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.StationDbToEntityMapper
import pl.arturborowy.rnm.data.local.stations.cache.mapper.StationEntityToDbMapper
import pl.arturborowy.rnm.domain.stations.StationsLocalRepository
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsRoomRepository(
    private val appDatabase: AppDatabase,
    private val keywordDbToEntityMapper: KeywordDbToEntityMapper,
    private val keywordEntityToDbMapper: KeywordEntityToDbMapper,
    private val stationDbToEntityMapper: StationDbToEntityMapper,
    private val stationEntityToDbMapper: StationEntityToDbMapper
) : StationsLocalRepository {

    override fun getKeywords() =
        Single.create<List<KeywordEntity>> { emitter ->
            emitter.onSuccess(
                appDatabase.keywordsDao()
                    .getAll()
                    .map { keywordDbToEntityMapper.map(it) }
            )
        }

    override fun setKeywords(keywords: List<KeywordEntity>) =
        Completable.create { emitter ->
            appDatabase.keywordsDao().insertAll(keywords.map { keywordEntityToDbMapper.map(it) })
            emitter.onComplete()
        }

    override fun getStations() =
        Single.create<List<StationEntity>> { emitter ->
            emitter.onSuccess(
                appDatabase.stationsDao()
                    .getAll()
                    .map { stationDbToEntityMapper.map(it) }
            )
        }

    override fun setStations(stations: List<StationEntity>) =
        Completable.create { emitter ->
            appDatabase.stationsDao().insertAll(stations.map { stationEntityToDbMapper.map(it) })
            emitter.onComplete()
        }
}