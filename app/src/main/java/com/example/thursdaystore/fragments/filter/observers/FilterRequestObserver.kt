package com.example.thursdaystore.fragments.filter.observers

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse

open class FilterRequestObserver(private val rc: RecyclerView, private val viewModel: FilterViewModel):Observer<List<FilterResponse>> {

    override fun onChanged(it: List<FilterResponse>) {
        rc.adapter = FilterParagraphAdapter(it,viewModel)
    }
}