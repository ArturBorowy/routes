package pl.arturborowy.rnm.stationssearch

import pl.arturborowy.rnm.R
import pl.arturborowy.rnm.base.ui.fragment.BaseFragment

class StationsSearchFragment(characterListViewModel: StationsSearchViewModel) :
    BaseFragment<StationsSearchViewModel>(
        characterListViewModel,
        R.layout.fragment_stations_search
    ) {
}