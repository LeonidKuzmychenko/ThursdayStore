package my.diploma.thursdaystore.fragments.filter.observers

import androidx.lifecycle.Observer
import my.diploma.thursdaystore.fragments.filter.FilterFragment
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest

class SavedFilterObserver(private val f:FilterFragment): Observer<ApplyFilterItemRequest?> {

    override fun onChanged(filter: ApplyFilterItemRequest?) {
        filter?.let {
            f.setSeekBarText(it.price.max.toString())
        }
    }
}