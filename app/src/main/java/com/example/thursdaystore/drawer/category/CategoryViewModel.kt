package com.example.thursdaystore.drawer.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is category Fragment" }
}