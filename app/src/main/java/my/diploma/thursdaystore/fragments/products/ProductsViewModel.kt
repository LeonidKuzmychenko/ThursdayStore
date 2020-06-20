package my.diploma.thursdaystore.fragments.products

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsViewModel : ViewModel(){
    val listLiveData: MutableLiveData<MutableList<ProductResponse>> = MutableLiveData()
}