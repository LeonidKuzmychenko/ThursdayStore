package com.example.thursdaystore.fragments.filter.observers

import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.fragments.filter.adapters.FilterParagraphAdapter
import com.example.thursdaystore.fragments.filter.listeners.PriceSeekBarChangeListener
import com.example.thursdaystore.retrofit.dto.filter.response.FilterItem

open class FilterRequestObserver(private val rc: RecyclerView,
                                 private val seekBar: AppCompatSeekBar,
                                 private val priceMax: TextView,
                                 private val viewModel: FilterViewModel):Observer<FilterItem> {

    override fun onChanged(it: FilterItem) {
//        seekBar.max = it.filterPrices.max
        seekBar.max = 120
        seekBar.setOnSeekBarChangeListener(PriceSeekBarChangeListener(priceMax, viewModel))
        rc.adapter = FilterParagraphAdapter(it.properties,viewModel)
    }
}