package my.diploma.thursdaystore.fragments.sub_category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import my.diploma.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse

class SubCategoryViewModel : ViewModel(){
    val listLiveData: MutableLiveData<List<SubcategoryResponse>> = MutableLiveData()
}