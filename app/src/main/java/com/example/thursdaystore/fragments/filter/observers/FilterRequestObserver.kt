package com.example.thursdaystore.fragments.filter.observers

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import com.example.thursdaystore.retrofit.dto.filter.response.FilterItem

open class FilterRequestObserver(private val rc: RecyclerView, private val viewModel: FilterViewModel):Observer<FilterItem> {

    override fun onChanged(it: FilterItem) {
        rc.adapter = FilterParagraphAdapter(it.properties,viewModel)
    }
}