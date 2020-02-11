package com.example.thursdaystore.drawer.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is favorites Fragment" }
}