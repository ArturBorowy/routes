package pl.arturborowy.rnm.stationssearch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

class StationsSearchAdapter(context: Context) :
    ArrayAdapter<KeywordEntity>(context, android.R.layout.simple_dropdown_item_1line) {

    var stations = listOf<StationEntity>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(
            android.R.layout.simple_dropdown_item_1line,
            parent,
            false
        ) as TextView

        val name = stations.firstOrNull { it.id == getItem(position)?.stationId }?.name
        view.text = name

        return view
    }
}