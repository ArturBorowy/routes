package pl.arturborowy.rnm.data.local.stations.cache.meta

import pl.arturborowy.rnm.base.date.DateConverter
import pl.arturborowy.rnm.base.local.sharedpreferences.SharedPreferencesRepository
import pl.arturborowy.rnm.domain.stations.meta.StationsCacheMetadataLocalRepository
import java.util.*

class StationsCacheMetadataSpRepository(
    sharedPreferencesRepository: SharedPreferencesRepository,
    private val dateConverter: DateConverter
) : StationsCacheMetadataLocalRepository {

    override var cacheCreationTime: Date?
        set(value) {
            _cacheCreationTime = dateConverter.convert(value!!)
        }
        get() = dateConverter.convert(_cacheCreationTime!!)

    private var _cacheCreationTime by sharedPreferencesRepository.stringPref()
}