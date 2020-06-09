package my.diploma.thursdaystore.fragments.filter.listeners

import android.widget.SeekBar
import my.diploma.thursdaystore.fragments.filter.FilterViewModel

class PriceSeekBarChangeListener(
    private val viewModel: FilterViewModel
) : SeekBar.OnSeekBarChangeListener {

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        val value = if (progress.toLong() == 0L) 1 else progress.toLong()
        viewModel.savedFilter.value?.let {
            it.price.max = value
            viewModel.savedFilter.value = it
        }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }
}