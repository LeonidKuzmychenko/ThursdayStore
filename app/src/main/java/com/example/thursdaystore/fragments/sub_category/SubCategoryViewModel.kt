package com.example.thursdaystore.fragments.sub_category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse

class SubCategoryViewModel : ViewModel(){
    val listLiveData: MutableLiveData<List<SubcategoryResponse>> = MutableLiveData()
}