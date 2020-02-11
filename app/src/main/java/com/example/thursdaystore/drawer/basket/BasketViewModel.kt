package com.example.thursdaystore.drawer.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BasketViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is basket Fragment" }
}
