package com.example.thursdaystore.fragments.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest

class FilterViewModel : ViewModel(){
    val liveDataFilterUi: MutableLiveData<List<FilterResponse>> = MutableLiveData()
    val liveDataFilter: MutableLiveData<ApplyFilterRequest> = MutableLiveData()
}