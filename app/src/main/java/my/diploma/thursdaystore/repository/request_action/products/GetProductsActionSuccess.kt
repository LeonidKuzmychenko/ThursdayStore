package my.diploma.thursdaystore.repository.request_action.products

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetProductsActionSuccess(private val liveData: MutableLiveData<MutableList<ProductResponse>>): Consumer<Response<MutableList<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<MutableList<ProductResponse>>) {
        Log.d(TAG, "getProducts Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getProducts Content = $response")
        }
        liveData.value = t.body()
    }

}