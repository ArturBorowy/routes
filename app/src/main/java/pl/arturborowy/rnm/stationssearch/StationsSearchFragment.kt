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

        val departureAdapter = StationsSearchAdapter(requireContext())
        departureSearch.setAdapter(departureAdapter)

        val destinationAdapter = StationsSearchAdapter(requireContext())
        destinationSearch.setAdapter(destinationAdapter)

        departureSearch.setOnItemClickListener { _, _, position, _ ->
            viewModel.selectedDepartureStation.set(departureAdapter.getItem(position))
        }

        destinationSearch.setOnItemClickListener { _, _, position, _ ->
            viewModel.selectedDestinationStation.set(destinationAdapter.getItem(position))
        }

        viewModel.stations.addOnPropertyChangedCallback {
            if (it != null) {
                departureAdapter.clear()
                departureAdapter.addAll(it)

                destinationAdapter.clear()
                destinationAdapter.addAll(it)
            }
        }
    }
}