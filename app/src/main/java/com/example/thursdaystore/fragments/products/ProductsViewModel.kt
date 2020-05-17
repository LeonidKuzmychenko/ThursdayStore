package com.example.thursdaystore.fragments.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsViewModel : ViewModel(){
    val listLiveData: MutableLiveData<List<ProductResponse>> = MutableLiveData()
}