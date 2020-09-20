package pl.arturborowy.rnm.data.local.stations.cache.mapper

import pl.arturborowy.rnm.data.local.stations.cache.model.StationDb
import pl.arturborowy.rnm.data.remote.Mapper
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationDbToEntityMapper : Mapper<StationDb, StationEntity> {

    override fun map(from: StationDb) =
        StationEntity(
            from.country,
            from.hits,
            from.id,
            from.name,
            from.localisedName,
            from.latitude,
            from.longitude
        )
}