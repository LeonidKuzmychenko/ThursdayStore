package my.diploma.thursdaystore.fragments.filter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.filter.request.ApplyFilterItemRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPricesRequest
import my.diploma.thursdaystore.retrofit.dto.filter.request.FilterPropertyRequest
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import my.diploma.thursdaystore.utils.Language

class FilterViewModel : ViewModel(){
    val filterUi: MutableLiveData<FilterItem> = MutableLiveData()
    val savedFilter: MutableLiveData<ApplyFilterItemRequest?> = MutableLiveData()

    fun setSavedFilter(filter: FilterItem, id: Long){
        val listOfFilterPropertyRequest: MutableList<FilterPropertyRequest> = mutableListOf()
        filter.properties.forEach { listOfFilterPropertyRequest.add(FilterPropertyRequest(it.propertyId, mutableListOf())) }
        savedFilter.value = ApplyFilterItemRequest(id, Language.getLanguage(), FilterPricesRequest(1,filter.price.max.toLong()), listOfFilterPropertyRequest)
    }
}