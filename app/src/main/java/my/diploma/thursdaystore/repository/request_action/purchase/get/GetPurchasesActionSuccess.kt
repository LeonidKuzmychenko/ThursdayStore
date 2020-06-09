package my.diploma.thursdaystore.repository.request_action.purchase.get

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.drawer.purchases.PurchasesFragment
import my.diploma.thursdaystore.retrofit.dto.purchases.get.GetPurchasesResponse
import retrofit2.Response

class GetPurchasesActionSuccess(private val f: PurchasesFragment): Consumer<Response<List<GetPurchasesResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<GetPurchasesResponse>>) {
        Log.d(TAG, "getPurchases Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getPurchases Content = $response")
        }

        t.body()?.let {
            f.setData(it)
        }
    }

}