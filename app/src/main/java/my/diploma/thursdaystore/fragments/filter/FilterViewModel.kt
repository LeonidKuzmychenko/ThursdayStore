package my.diploma.thursdaystore.fragments.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem

class FilterViewModel : ViewModel(){
    val liveDataFilterUi: MutableLiveData<FilterItem> = MutableLiveData()
    val savedFilterState: MutableLiveData<ApplyFilterItemRequest?> = MutableLiveData()

}