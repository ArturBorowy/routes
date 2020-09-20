package pl.arturborowy.rnm.data.local.stations.cache.mapper

import pl.arturborowy.rnm.data.local.stations.cache.model.KeywordDb
import pl.arturborowy.rnm.data.remote.Mapper
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity

class KeywordEntityToDbMapper : Mapper<KeywordEntity, KeywordDb> {

    override fun map(from: KeywordEntity) =
        KeywordDb(from.id, from.keyword, from.stationId)
}