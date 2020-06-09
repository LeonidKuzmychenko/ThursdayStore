package my.diploma.thursdaystore.fragments.filter.observers

import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_filter.*
import my.diploma.thursdaystore.fragments.filter.FilterFragment
import my.diploma.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import my.diploma.thursdaystore.fragments.filter.listeners.PriceSeekBarChangeListener
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem

class FilterUiObserver(private val f:FilterFragment, private val  id: Long): Observer<FilterItem> {

    override fun onChanged(filter: FilterItem) {
        try {
            f.setSeekBarMax(filter.price.max.toInt())
        } catch (e:Exception){
            f.setSeekBarMax(10000)
        }

        if (f.vm.savedFilter.value == null) {
            f.vm.setSavedFilter(filter, id)
        }
        f.setSeekBarProgress(f.vm.savedFilter.value!!.price.max.toInt())
        f.filterPriceSeekBar.setOnSeekBarChangeListener(PriceSeekBarChangeListener(f.vm))
        f.filterRecyclerView.adapter = FilterParagraphAdapter(filter.properties,f.vm)
    }
}