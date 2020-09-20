package pl.arturborowy.rnm.data.remote.stations.keywords

import com.google.gson.annotations.SerializedName

data class KeywordDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("keyword")
    val keyword: String,
    @SerializedName("station_id")
    val stationId: Long
)