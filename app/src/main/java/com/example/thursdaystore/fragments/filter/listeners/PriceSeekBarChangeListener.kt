package com.example.thursdaystore.fragments.filter.listeners

import android.widget.SeekBar
import android.widget.TextView
import com.example.thursdaystore.fragments.filter.FilterViewModel

class PriceSeekBarChangeListener(
    private val priceMax: TextView,
    private val viewModel: FilterViewModel
) : SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val value = if (progress.toLong() == 0L) 1 else progress.toLong()
        priceMax.text = value.toString()
        val filter = viewModel.liveDataFilterItem.value
        if (filter != null) {
            filter.filterPricesRequest.max = value
            viewModel.liveDataFilterItem.value = filter
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}