package com.example.thursdaystore.fragments.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest

class FilterViewModel : ViewModel(){
    val liveDataFilterUi: MutableLiveData<List<FilterResponse>> = MutableLiveData()
    val liveDataFilter: MutableLiveData<ApplyFilterRequest> = MutableLiveData()

//    fun getFilterProperties(): List<Property> {
//        return liveDataFilter.value!!.filters
//    }
//
//    fun addParameterToPropertyFilter(propertyId: Long, parameterId:Long){
//        val index = getIndexOfProperty(propertyId)
//        val newValue = liveDataFilter.value
//        newValue!!.filters[index].parameters.add(parameterId)
//        liveDataFilter.value = newValue
//    }
//
//    fun removeParameterFromPropertyFilter(propertyId: Long, parameterId:Long){
//        val index = getIndexOfProperty(propertyId)
//        val newValue = liveDataFilter.value
//        newValue!!.filters[index].parameters.remove(parameterId)
//        liveDataFilter.value = newValue
//    }
//
//    private fun getIndexOfProperty(propertyId: Long): Int {
//        val properties = liveDataFilter.value!!.filters
//        val property = properties.filter { it.propertyId == propertyId }[0]
//        return properties.indexOf(property)
//    }
}