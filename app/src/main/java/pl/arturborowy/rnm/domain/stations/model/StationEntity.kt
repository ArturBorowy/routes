package pl.arturborowy.rnm.domain.stations.model

data class StationEntity(
    val country: String,
    val hits: Int,
    val id: Long,
    val name: String,
    val localisedName: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null
) {
    override fun toString()= "${localisedName ?: name}, $country"
}