package com.example.thursdaystore.fragments.filter.observers

import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.example.thursdaystore.retrofit.dto.filter.request.Property
import com.example.thursdaystore.utils.Language

class FilterRequestObserverWithInit(rc: RecyclerView, private val viewModel: FilterViewModel, private val id: Long): FilterRequestObserver(rc, viewModel) {

    override fun onChanged(it: List<FilterResponse>) {
        super.onChanged(it)

        val listOfProperty: MutableList<Property> = mutableListOf()

        it.forEach {
            listOfProperty.add(Property(it.propertyId, mutableListOf()))
        }

        viewModel.liveDataFilter.value = ApplyFilterRequest(id, Language.getLanguage(), listOfProperty)
    }

}