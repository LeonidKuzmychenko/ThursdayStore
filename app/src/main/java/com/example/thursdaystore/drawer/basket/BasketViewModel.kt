package com.example.thursdaystore.drawer.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketViewModel : ViewModel() {
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}
