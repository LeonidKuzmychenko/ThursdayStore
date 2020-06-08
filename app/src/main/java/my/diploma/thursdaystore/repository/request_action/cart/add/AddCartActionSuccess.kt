package my.diploma.thursdaystore.repository.request_action.cart.add

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class AddCartActionSuccess: Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "addCart Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "addCart Content = $response")
        }
    }

}