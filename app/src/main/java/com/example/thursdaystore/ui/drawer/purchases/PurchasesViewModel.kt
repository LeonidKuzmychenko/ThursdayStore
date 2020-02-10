package com.example.thursdaystore.ui.drawer.purchases

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PurchasesViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is purchases Fragment" }
}