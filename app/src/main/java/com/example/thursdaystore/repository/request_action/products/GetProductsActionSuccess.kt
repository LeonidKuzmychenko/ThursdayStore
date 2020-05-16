package com.example.thursdaystore.repository.request_action.products

import android.util.Log
import com.example.thursdaystore.retrofit.dto.product.ProductResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetProductsActionSuccess: Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "getProducts Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getProducts Content = $response")
        }
    }

}