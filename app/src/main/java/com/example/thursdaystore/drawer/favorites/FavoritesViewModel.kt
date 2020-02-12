package com.example.thursdaystore.drawer.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}