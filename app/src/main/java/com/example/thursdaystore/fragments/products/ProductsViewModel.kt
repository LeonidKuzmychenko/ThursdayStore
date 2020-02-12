package com.example.thursdaystore.fragments.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductsViewModel : ViewModel(){
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}