package com.example.thursdaystore.drawer.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}