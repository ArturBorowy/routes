package pl.arturborowy.rnm.data.remote

import io.reactivex.Single
import pl.arturborowy.rnm.data.remote.stations.StationDto
import retrofit2.http.GET

interface StationsService {

    companion object {
        const val API_BASE_URL = "https://koleo.pl/api/v2/"
    }

    @GET("main/stations")
    fun getStations(): Single<List<StationDto>>
}