package pl.arturborowy.rnm.data.remote.stations

import com.google.gson.annotations.SerializedName

data class StationDto(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("hits")
    val hits: Int,
    @SerializedName("ibnr")
    val ibnr: Int? = null,
    @SerializedName("id")
    val id: Long,
    @SerializedName("latitude")
    val latitude: Double? = null,
    @SerializedName("localised_name")
    val localisedName: String? = null,
    @SerializedName("longitude")
    val longitude: Double? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("name_slug")
    val nameSlug: String,
    @SerializedName("region")
    val region: String
)