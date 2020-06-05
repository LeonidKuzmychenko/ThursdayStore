package my.diploma.thursdaystore.drawer.purchases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PurchasesViewModel : ViewModel() {
    val listLiveData: MutableLiveData<MutableList<Int>> = MutableLiveData()
}