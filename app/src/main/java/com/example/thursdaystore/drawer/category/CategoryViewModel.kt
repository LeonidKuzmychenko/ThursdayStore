package com.example.thursdaystore.drawer.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse

class CategoryViewModel : ViewModel() {
    val listLiveData: MutableLiveData<List<CategoryResponse>> = MutableLiveData()
}