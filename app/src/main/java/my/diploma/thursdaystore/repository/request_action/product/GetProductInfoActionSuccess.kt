package my.diploma.thursdaystore.repository.request_action.product

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.fragments.product_tree.ProductInfoFragment
import my.diploma.thursdaystore.retrofit.dto.product.ProductInfoResponse
import retrofit2.Response

class GetProductInfoActionSuccess(private val f:ProductInfoFragment): Consumer<Response<ProductInfoResponse>> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<ProductInfoResponse>) {
        Log.d(TAG, "getProductInfo Response = $t")
        t.body()?.let{ item ->
            Log.d(TAG, "getProductInfo Content = $item")

            f.setImage(item.images[0])
            item.inFavorites?.let { f.setFavoriteState(it) }
            item.inCart?.let { f.setCartState(it) }

            f.setFavoriteListener(item.id)
            f.setCartListener(item.id)

            item.name?.let { f.setTitle(it) }

            f.setPrice(item.price)

            f.setDescription(item.description)

            f.setCharacteristics(item.properties)
        }
    }
}