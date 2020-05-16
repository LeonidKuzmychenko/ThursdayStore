package com.example.thursdaystore.repository.request_action.categories

import android.util.Log
import com.example.thursdaystore.retrofit.dto.category.CategoryResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetCategoriesActionSuccess: Consumer<Response<List<CategoryResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<CategoryResponse>>) {
        Log.d(TAG, "getCategories Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getCategories Content = $response")
        }
    }

}