package pl.arturborowy.rnm.stationssearch

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_stations_search.*
import pl.arturborowy.rnm.R
import pl.arturborowy.rnm.base.ui.addOnPropertyChangedCallback
import pl.arturborowy.rnm.base.ui.fragment.BaseFragment

class StationsSearchFragment(stationsSearchViewModel: StationsSearchViewModel) :
    BaseFragment<StationsSearchViewModel>(
        stationsSearchViewModel,
        R.layout.fragment_stations_search
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = StationsSearchAdapter(requireContext())
        searchView.setAdapter(adapter)

        viewModel.stations.addOnPropertyChangedCallback {
            if (it != null) {
                adapter.clear()
                adapter.addAll(it)
            }
        }
    }
}