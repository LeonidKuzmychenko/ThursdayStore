package my.diploma.thursdaystore.drawer.purchases

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.purchases.get.GetPurchasesResponse

class PurchasesViewModel : ViewModel() {
    val listLiveData: MutableLiveData<List<GetPurchasesResponse>> = MutableLiveData()
}