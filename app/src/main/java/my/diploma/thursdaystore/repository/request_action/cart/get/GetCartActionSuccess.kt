package my.diploma.thursdaystore.repository.request_action.cart.get

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetCartActionSuccess(private val liveData: MutableLiveData<List<ProductResponse>>): Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "getCart Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getCart Content = $response")
        }
        liveData.value = t.body()
    }

}