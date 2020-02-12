package com.example.thursdaystore.fragments.product_tree.product.specifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpecificationsViewModel : ViewModel(){
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}