package pl.arturborowy.rnm.data.remote.stations.mapper

import pl.arturborowy.rnm.data.remote.Mapper
import pl.arturborowy.rnm.data.remote.stations.StationDto
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationDtoToEntityMapper : Mapper<StationDto, StationEntity> {

    override fun map(from: StationDto) =
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