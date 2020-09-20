package pl.arturborowy.rnm.stationssearch

import androidx.databinding.ObservableField
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import pl.arturborowy.rnm.base.error.ThrowableHandler
import pl.arturborowy.rnm.base.rx.SchedulerProvider
import pl.arturborowy.rnm.base.rx.setSchedulers
import pl.arturborowy.rnm.base.ui.addOnPropertyChangedCallback
import pl.arturborowy.rnm.base.ui.view.LoadingScreenViewModel
import pl.arturborowy.rnm.base.ui.viewmodel.FragmentViewModel
import pl.arturborowy.rnm.base.ui.viewmodel.RxJavaSubscriber
import pl.arturborowy.rnm.domain.stations.StationsInteractor
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsSearchViewModel(
    private val stationsInteractor: StationsInteractor,
    override val disposables: CompositeDisposable,
    private val schedulerProvider: SchedulerProvider,
    private val throwableHandler: ThrowableHandler,
    val loadingScreenViewModel: LoadingScreenViewModel
) : FragmentViewModel(), RxJavaSubscriber {

    companion object {
        private const val EMPTY_ROUTE_LENGTH = 0.0
    }

    val stations = ObservableField<MutableList<StationEntity>>(mutableListOf())
    val keywords = ObservableField<MutableList<KeywordEntity>>(mutableListOf())

    val selectedDepartureStation = ObservableField<StationEntity>()
    val selectedDestinationStation = ObservableField<StationEntity>()

    val departureInput = ObservableField("")
    val destinationInput = ObservableField("")

    val routeLength = ObservableField(EMPTY_ROUTE_LENGTH)

    override fun onViewCreated() {
        super.onViewCreated()
        fetchStationsAndKeywords()
        countRouteLengthOnSelectedStationChange()
        resetRouteLengthOnStationTextInput()
    }

    private fun fetchStationsAndKeywords() {
        loadingScreenViewModel.show()

        stationsInteractor.getStationsAndKeywords()
            .setSchedulers(schedulerProvider)
            .doAfterTerminate(loadingScreenViewModel::hide)
            .subscribeBy(
                onSuccess = { (stations, keywords) ->
                    this.keywords.set(keywords.toMutableList())
                    this.stations.set(stations.toMutableList())
                },
                onError ={ throwableHandler.handle(it)}
            ).addToSubs()
    }

    private fun countRouteLengthOnSelectedStationChange() {
        selectedDepartureStation.addOnPropertyChangedCallback { countRouteLength() }
        selectedDestinationStation.addOnPropertyChangedCallback { countRouteLength() }
    }

    private fun countRouteLength() {
        if (selectedDepartureStation.get() != null && selectedDestinationStation.get() != null) {
            routeLength.set(
                stationsInteractor.getDistance(
                    selectedDepartureStation.get()!!,
                    selectedDestinationStation.get()!!
                )
            )
        } else {
            routeLength.set(EMPTY_ROUTE_LENGTH)
        }
    }

    private fun resetRouteLengthOnStationTextInput() {
        departureInput.addOnPropertyChangedCallback { routeLength.set(EMPTY_ROUTE_LENGTH) }
        destinationInput.addOnPropertyChangedCallback { routeLength.set(EMPTY_ROUTE_LENGTH) }
    }
}