package pl.arturborowy.rnm.domain.stations.model

data class StationEntity(
    val city: String,
    val country: String,
    val hits: Int,
    val ibnr: Int? = null,
    val id: Long,
    val latitude: Double? = null,
    val localisedName: String? = null,
    val longitude: Double? = null,
    val name: String,
    val nameSlug: String,
    val region: String
) {
    override fun toString()= name
}