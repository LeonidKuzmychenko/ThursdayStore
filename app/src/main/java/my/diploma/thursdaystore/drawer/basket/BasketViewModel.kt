package my.diploma.thursdaystore.drawer.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class BasketViewModel : ViewModel() {
    val listLiveData: MutableLiveData<List<ProductResponse>> = MutableLiveData()
}
