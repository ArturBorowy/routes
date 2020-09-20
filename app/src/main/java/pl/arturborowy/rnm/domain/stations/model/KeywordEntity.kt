package pl.arturborowy.rnm.domain.stations.model

data class KeywordEntity(
    val id: Long,
    val keyword: String,
    val stationId: Long
)