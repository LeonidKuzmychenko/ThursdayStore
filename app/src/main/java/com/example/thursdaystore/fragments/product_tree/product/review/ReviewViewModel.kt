package com.example.thursdaystore.fragments.product_tree.product.review

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReviewViewModel : ViewModel(){
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}