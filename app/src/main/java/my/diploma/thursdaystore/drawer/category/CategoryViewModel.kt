package my.diploma.thursdaystore.drawer.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse

class CategoryViewModel : ViewModel() {
    val listLiveData: MutableLiveData<List<CategoryResponse>> = MutableLiveData()
}