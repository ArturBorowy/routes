package pl.arturborowy.rnm.stationssearch

import androidx.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import pl.arturborowy.rnm.base.error.ThrowableHandler
import pl.arturborowy.rnm.base.rx.SchedulerProvider
import pl.arturborowy.rnm.base.rx.setSchedulers
import pl.arturborowy.rnm.base.ui.viewmodel.FragmentViewModel
import pl.arturborowy.rnm.base.ui.viewmodel.RxJavaSubscriber
import pl.arturborowy.rnm.domain.stations.StationsRemoteRepository
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsSearchViewModel(
    private val stationsRemoteRepository: StationsRemoteRepository,
    override val disposables: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider,
    private val throwableHandler: ThrowableHandler
) : FragmentViewModel(), RxJavaSubscriber {

    val stations = ObservableField<MutableList<StationEntity>>(mutableListOf())

    override fun onViewCreated() {
        super.onViewCreated()

        stationsRemoteRepository.getStations()
            .setSchedulers(schedulerProvider)
            .subscribeBy(
                onSuccess = {
                    stations.get()?.clear()
                    stations.get()?.addAll(it)
                    stations.notifyChange()
                },
                onError = throwableHandler::handle
            ).addToSubs()
    }
}