package my.diploma.thursdaystore.repository.request_action.cart.get

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.drawer.basket.BasketFragment
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetCartActionSuccess(private val f: BasketFragment): Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "getCart Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getCart Content = $response")
        }

        f.stopSkeleton()
        f.basketViewModel.listLiveData.value = t.body()
    }

}