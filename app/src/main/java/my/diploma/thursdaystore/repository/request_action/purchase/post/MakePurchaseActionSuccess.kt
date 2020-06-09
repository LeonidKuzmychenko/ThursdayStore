package my.diploma.thursdaystore.repository.request_action.purchase.post

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.purchases.post.MakePurchasesResponse
import retrofit2.Response

class MakePurchaseActionSuccess: Consumer<Response<MakePurchasesResponse>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<MakePurchasesResponse>) {
        Log.d(TAG, "makePurchase Response = $t")
        t.body()?.let { response ->
            Log.d(TAG, "makePurchase Content = $response")
        }

    }

}