package my.diploma.thursdaystore.fragments.filter.observers

import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import my.diploma.thursdaystore.fragments.filter.FilterViewModel
import my.diploma.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem

open class FilterRequestObserver(private val rc: RecyclerView,
                                 private val seekBar: AppCompatSeekBar,
                                 private val priceMax: TextView,
                                 private val viewModel: FilterViewModel):Observer<FilterItem> {

    override fun onChanged(it: FilterItem) {
        try {
            seekBar.max = it.filterPrices.max.toInt()
        }catch (e:Exception){
            seekBar.max = 10000
        }

        priceMax.text = it.filterPrices.max
        seekBar.progress = it.filterPrices.max.toInt()

        val filter = viewModel.liveDataFilterItem.value
        if (filter != null) {
            priceMax.text = filter.filterPricesRequest.max.toString()
            seekBar.progress = filter.filterPricesRequest.max.toInt()
        }

        rc.adapter = FilterParagraphAdapter(it.properties,viewModel)
    }
}