package com.example.thursdaystore.fragments.sub_category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubCategoryViewModel : ViewModel(){
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}