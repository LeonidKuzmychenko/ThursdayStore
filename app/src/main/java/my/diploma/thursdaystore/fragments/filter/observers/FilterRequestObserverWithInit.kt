package my.diploma.thursdaystore.fragments.filter.observers

import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.fragments.filter.FilterViewModel
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPricesRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPropertyRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import my.diploma.thursdaystore.utils.Language

class FilterRequestObserverWithInit(
    rc: RecyclerView,
    private val seekBar: AppCompatSeekBar,
    priceMax: TextView,
    private val viewModel: FilterViewModel,
    private val id: Long
) : FilterRequestObserver(rc,seekBar, priceMax, viewModel) {

    override fun onChanged(it: FilterItem) {
        super.onChanged(it)

//        seekBar.progress = it.filterPrices.max.toInt()

        val listOfFilterPropertyRequest: MutableList<FilterPropertyRequest> = mutableListOf()

        it.properties.forEach {
            listOfFilterPropertyRequest.add(FilterPropertyRequest(it.propertyId, mutableListOf()))
        }

        viewModel.liveDataFilterItem.value = ApplyFilterItemRequest(id, Language.getLanguage(), FilterPricesRequest(1,it.filterPrices.max.toLong()), listOfFilterPropertyRequest)
    }

}