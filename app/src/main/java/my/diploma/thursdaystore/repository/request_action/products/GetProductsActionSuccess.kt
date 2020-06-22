package my.diploma.thursdaystore.repository.request_action.products

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.fragments.products.ProductsFragment
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetProductsActionSuccess(private val f: ProductsFragment): Consumer<Response<MutableList<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<MutableList<ProductResponse>>) {
        Log.d(TAG, "getProducts Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getProducts Content = $response")
        }
        f.stopSkeleton()
        f.productsViewModel.listLiveData.value = t.body()
    }

}