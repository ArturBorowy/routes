package pl.arturborowy.rnm.domain.stations.mapper

import pl.arturborowy.rnm.data.remote.Mapper
import pl.arturborowy.rnm.data.remote.stations.keywords.KeywordDto
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity

class KeywordDtoToEntityMapper : Mapper<KeywordDto, KeywordEntity> {

    override fun map(from: KeywordDto) =
        KeywordEntity(from.id, from.keyword, from.stationId)
}