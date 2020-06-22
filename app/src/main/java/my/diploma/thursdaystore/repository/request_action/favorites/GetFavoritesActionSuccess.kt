package my.diploma.thursdaystore.repository.request_action.favorites

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.drawer.favorites.FavoritesFragment
import my.diploma.thursdaystore.retrofit.dto.product.ProductResponse
import retrofit2.Response

class GetFavoritesActionSuccess(private val f: FavoritesFragment): Consumer<Response<List<ProductResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<ProductResponse>>) {
        Log.d(TAG, "GetFavorites Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "GetFavorites Content = $response")
        }

        f.stopSkeleton()
        f.favoritesViewModel.liveData.value = t.body()
    }

}