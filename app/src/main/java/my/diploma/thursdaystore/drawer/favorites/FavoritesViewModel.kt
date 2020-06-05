package my.diploma.thursdaystore.drawer.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoritesViewModel : ViewModel() {
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}