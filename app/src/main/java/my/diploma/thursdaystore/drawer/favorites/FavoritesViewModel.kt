package my.diploma.thursdaystore.drawer.favorites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class FavoritesViewModel : ViewModel() {
    val liveData: MutableLiveData<List<ProductResponse>> = MutableLiveData()
}