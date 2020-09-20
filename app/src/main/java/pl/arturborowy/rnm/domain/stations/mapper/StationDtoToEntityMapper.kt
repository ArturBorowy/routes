package pl.arturborowy.rnm.domain.stations.mapper

import pl.arturborowy.rnm.data.remote.Mapper
import pl.arturborowy.rnm.data.remote.stations.StationDto
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationDtoToEntityMapper : Mapper<StationDto, StationEntity> {

    override fun map(from: StationDto) =
        StationEntity(
            from.city,
            from.country,
            from.hits,
            from.ibnr,
            from.id,
            from.latitude,
            from.localisedName,
            from.longitude,
            from.name,
            from.nameSlug,
            from.region
        )
}