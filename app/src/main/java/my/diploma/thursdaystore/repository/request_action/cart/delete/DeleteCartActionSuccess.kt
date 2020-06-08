package my.diploma.thursdaystore.repository.request_action.cart.delete

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class DeleteCartActionSuccess : Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "deleteCart Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "deleteCart Content = $response")
        }
    }

}