package pl.arturborowy.rnm.data.remote.stations.keywords

import com.google.gson.annotations.SerializedName

data class KeywordDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("keyword")
    val keyword: String,
    @SerializedName("station_id")
    val stationId: Int
)