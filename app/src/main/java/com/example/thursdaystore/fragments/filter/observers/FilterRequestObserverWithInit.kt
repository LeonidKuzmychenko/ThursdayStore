package com.example.thursdaystore.fragments.filter.observers

import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import com.example.thursdaystore.retrofit.dto.filter.request.FilterPricesRequest
import com.example.thursdaystore.retrofit.dto.filter.request.FilterPropertyRequest
import com.example.thursdaystore.retrofit.dto.filter.response.FilterItem
import com.example.thursdaystore.utils.Language

class FilterRequestObserverWithInit(
    rc: RecyclerView,
    seekBar: AppCompatSeekBar,
    priceMax: TextView,
    private val viewModel: FilterViewModel,
    private val id: Long
) : FilterRequestObserver(rc,seekBar, priceMax, viewModel) {

    override fun onChanged(it: FilterItem) {
        super.onChanged(it)

        val listOfFilterPropertyRequest: MutableList<FilterPropertyRequest> = mutableListOf()

        it.properties.forEach {
            listOfFilterPropertyRequest.add(FilterPropertyRequest(it.propertyId, mutableListOf()))
        }

        viewModel.liveDataFilterItem.value =
            ApplyFilterItemRequest(id, Language.getLanguage(), FilterPricesRequest(1,1), listOfFilterPropertyRequest)
    }

}