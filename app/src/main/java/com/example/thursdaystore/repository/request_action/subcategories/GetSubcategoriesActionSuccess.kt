package com.example.thursdaystore.repository.request_action.subcategories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.retrofit.dto.subcategory.SubcategoryResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetSubcategoriesActionSuccess(val liveData: MutableLiveData<List<SubcategoryResponse>>): Consumer<Response<List<SubcategoryResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<SubcategoryResponse>>) {
        Log.d(TAG, "getSubcategories Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getSubcategories Content = $response")
        }

        liveData.value = t.body()
    }

}