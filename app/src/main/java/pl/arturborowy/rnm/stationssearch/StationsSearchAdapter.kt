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
    ArrayAdapter<StationEntity>(context, android.R.layout.simple_dropdown_item_1line) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(
            android.R.layout.simple_dropdown_item_1line,
            parent,
            false
        ) as TextView

        val name = getItem(position)?.name
        view.text = name

        return view
    }
}