package pl.arturborowy.rnm.stationssearch

import androidx.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.zipWith
import pl.arturborowy.rnm.base.error.ThrowableHandler
import pl.arturborowy.rnm.base.rx.SchedulerProvider
import pl.arturborowy.rnm.base.rx.setSchedulers
import pl.arturborowy.rnm.base.ui.viewmodel.FragmentViewModel
import pl.arturborowy.rnm.base.ui.viewmodel.RxJavaSubscriber
import pl.arturborowy.rnm.domain.stations.StationsRemoteRepository
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsSearchViewModel(
    private val stationsRemoteRepository: StationsRemoteRepository,
    override val disposables: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider,
    private val throwableHandler: ThrowableHandler
) : FragmentViewModel(), RxJavaSubscriber {

    val stations = ObservableField<MutableList<StationEntity>>(mutableListOf())
    val keywords = ObservableField<MutableList<KeywordEntity>>(mutableListOf())

    override fun onViewCreated() {
        super.onViewCreated()

        stationsRemoteRepository.getStations()
            .zipWith(stationsRemoteRepository.getKeywords())
            .setSchedulers(schedulerProvider)
            .subscribeBy(
                onSuccess = { (stations, keywords) ->
                    setStations(stations)
                    setKeywords(keywords)
                },
                onError = throwableHandler::handle
            ).addToSubs()
    }

    private fun setKeywords(items: List<KeywordEntity>) {
        keywords.get()?.clear()
        keywords.get()?.addAll(filterKeywordsWithoutMatchingStation(items))
        keywords.notifyChange()
    }

    private fun filterKeywordsWithoutMatchingStation(keyWords: List<KeywordEntity>) =
        keyWords.filter { keyword -> hasMatchingStation(keyword) }

    private fun hasMatchingStation(keyword: KeywordEntity) =
        stations.get()?.any { station -> station.id == keyword.stationId } == true

    private fun setStations(items: List<StationEntity>) {
        stations.get()?.clear()
        stations.get()?.addAll(items)
        stations.notifyChange()
    }
}