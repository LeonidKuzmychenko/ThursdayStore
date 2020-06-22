package my.diploma.thursdaystore.repository.request_action.categories

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.drawer.category.CategoryFragment
import my.diploma.thursdaystore.retrofit.dto.category.CategoryResponse
import retrofit2.Response

class GetCategoriesActionSuccess(private val f: CategoryFragment) :
    Consumer<Response<List<CategoryResponse>>> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<CategoryResponse>>) {
        Log.d(TAG, "getCategories Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getCategories Content = $response")
        }

        f.stopSkeleton()
        f.categoryViewModel.listLiveData.value = t.body()
    }

}