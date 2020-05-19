package com.example.thursdaystore.fragments.filter.observers

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.Language
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.example.thursdaystore.retrofit.dto.filter.request.Property

class FilterRequestObserverWithInit(rc: RecyclerView, private val liveDataFilter: MutableLiveData<ApplyFilterRequest>, private val id: Long): FilterRequestObserver(rc) {

    override fun onChanged(it: List<FilterResponse>) {
        super.onChanged(it)

        val listOfProperty: MutableList<Property> = mutableListOf()

        it.forEach {
            listOfProperty.add(Property(it.propertyId, listOf()))
        }

        liveDataFilter.value = ApplyFilterRequest(id, Language.getLanguage(), listOfProperty)
    }

}