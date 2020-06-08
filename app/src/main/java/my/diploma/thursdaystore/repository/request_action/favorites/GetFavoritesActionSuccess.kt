package my.diploma.thursdaystore.repository.request_action.favorites

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetFavoritesActionSuccess(private val liveData: MutableLiveData<List<ProductResponse>>): Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "GetFavorites Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "GetFavorites Content = $response")
        }
        liveData.value = t.body()
    }

}