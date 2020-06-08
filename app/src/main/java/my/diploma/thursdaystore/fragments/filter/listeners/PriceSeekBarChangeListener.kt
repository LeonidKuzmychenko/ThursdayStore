package my.diploma.thursdaystore.fragments.filter.listeners

import android.widget.SeekBar
import android.widget.TextView
import my.diploma.thursdaystore.fragments.filter.FilterViewModel

class PriceSeekBarChangeListener(
    private val priceMax: TextView,
    private val viewModel: FilterViewModel
) : SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val value = if (progress.toLong() == 0L) 1 else progress.toLong()
        priceMax.text = value.toString()
        viewModel.savedFilterState.value?.let {
            it.filterPricesRequest.max = value
            viewModel.savedFilterState.value = it
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}