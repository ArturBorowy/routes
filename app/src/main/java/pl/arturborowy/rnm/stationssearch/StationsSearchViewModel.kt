package pl.arturborowy.rnm.stationssearch

import androidx.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import pl.arturborowy.rnm.base.error.ThrowableHandler
import pl.arturborowy.rnm.base.rx.SchedulerProvider
import pl.arturborowy.rnm.base.rx.setSchedulers
import pl.arturborowy.rnm.base.ui.viewmodel.FragmentViewModel
import pl.arturborowy.rnm.base.ui.viewmodel.RxJavaSubscriber
import pl.arturborowy.rnm.domain.stations.StationsInteractor
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsSearchViewModel(
    private val stationsInteractor: StationsInteractor,
    override val disposables: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider,
    private val throwableHandler: ThrowableHandler
) : FragmentViewModel(), RxJavaSubscriber {

    val stations = ObservableField<MutableList<StationEntity>>(mutableListOf())
    val keywords = ObservableField<MutableList<KeywordEntity>>(mutableListOf())

    override fun onViewCreated() {
        super.onViewCreated()

        stationsInteractor.getStationsAndKeywords()
            .setSchedulers(schedulerProvider)
            .subscribeBy(
                onSuccess = { (stations, keywords) ->
                    this.keywords.set(keywords.toMutableList())
                    this.stations.set(stations.toMutableList())
                },
                onError = throwableHandler::handle
            ).addToSubs()
    }
}