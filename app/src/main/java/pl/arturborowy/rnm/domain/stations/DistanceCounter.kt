package pl.arturborowy.rnm.domain.stations

import kotlin.math.asin

class DistanceCounter {

    companion object {
       const val EARTCH_RADIUS_KM = 6372.8
    }

    fun betweenPointsOnSphere(lat1: Double, lon1: Double, lat2: Double, lon2: Double): Double {
        val λ1 = Math.toRadians(lat1)
        val λ2 = Math.toRadians(lat2)
        val Δλ = Math.toRadians(lat2 - lat1)
        val Δφ = Math.toRadians(lon2 - lon1)
        return 2 * EARTCH_RADIUS_KM * asin(
            Math.sqrt(
                Math.pow(
                    Math.sin(Δλ / 2),
                    2.0
                ) + Math.pow(Math.sin(Δφ / 2), 2.0) * Math.cos(λ1) * Math.cos(λ2)
            )
        )
    }
}