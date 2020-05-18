package com.example.thursdaystore.fragments.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse

class FilterViewModel : ViewModel(){
    val liveData: MutableLiveData<List<FilterResponse>> = MutableLiveData()
}