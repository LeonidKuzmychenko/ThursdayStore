package com.example.thursdaystore.fragments.filter.observers

import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.filter.FilterViewModel
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.example.thursdaystore.retrofit.dto.filter.request.Prices
import com.example.thursdaystore.retrofit.dto.filter.request.Property
import com.example.thursdaystore.retrofit.dto.filter.response.FilterItem
import com.example.thursdaystore.utils.Language

class FilterRequestObserverWithInit(
    rc: RecyclerView,
    private val seekBar: AppCompatSeekBar,
    private val priceMax: TextView,
    private val viewModel: FilterViewModel,
    private val id: Long
) : FilterRequestObserver(rc, viewModel) {

    override fun onChanged(it: FilterItem) {
        super.onChanged(it)

        val listOfProperty: MutableList<Property> = mutableListOf()

        it.properties.forEach {
            listOfProperty.add(Property(it.propertyId, mutableListOf()))
        }

//        seekBar.max = it.filterPrices.max.toInt()
        seekBar.max = 100000

        viewModel.liveDataFilter.value =
            ApplyFilterRequest(id, Language.getLanguage(), Prices(0,0), listOfProperty)

//        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//                priceMax.text = progress.toString()
//                val filter = viewModel.liveDataFilter.value
//                if (filter != null){
//                    filter.prices.max = progress.toLong()
//                    viewModel.liveDataFilter.value = filter
//                }
//            }
//
//            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
//            }
//
//        })
    }

}