package com.example.thursdaystore.repository.request_action.subcategories

import android.util.Log
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetSubcategoriesActionSuccess: Consumer<Response<List<SubcategoryResponse>>>{

    val TAG = this.javaClass.canonicalName

    override fun accept(t: Response<List<SubcategoryResponse>>) {
        Log.d(TAG, "getSubcategories Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getSubcategories Content = $response")
        }
    }

}