package com.example.thursdaystore.repository.request_action.filters.apply

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class ApplyFilterActionSuccess(private val liveData: MutableLiveData<List<ProductResponse>>): Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "applyFilter Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "applyFilter Content = $response")
        }

        liveData.value = t.body()
    }

}