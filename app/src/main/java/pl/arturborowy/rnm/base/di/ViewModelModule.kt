package pl.arturborowy.rnm.base.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import pl.arturborowy.rnm.base.rx.RemoteFetchSchedulerProvider
import pl.arturborowy.rnm.base.ui.view.LoadingScreenViewModel
import pl.arturborowy.rnm.stationssearch.StationsSearchViewModel

val viewModelModule = module {

    factory { LoadingScreenViewModel() }

    single {
        StationsSearchViewModel(
            get(),
            get(),
            get(named<RemoteFetchSchedulerProvider>()),
            get()
        )
    }
}