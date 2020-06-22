package my.diploma.thursdaystore.repository.request_action.subcategories

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.fragments.sub_category.SubCategoryFragment
import my.diploma.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import retrofit2.Response

class GetSubcategoriesActionSuccess(private val f: SubCategoryFragment): Consumer<Response<List<SubcategoryResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<SubcategoryResponse>>) {
        Log.d(TAG, "getSubcategories Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getSubcategories Content = $response")
        }

        f.stopSkeleton()
        f.subCategoryViewModel.listLiveData.value = t.body()
    }

}