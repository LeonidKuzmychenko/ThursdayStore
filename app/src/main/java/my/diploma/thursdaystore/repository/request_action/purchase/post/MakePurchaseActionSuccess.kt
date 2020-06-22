package my.diploma.thursdaystore.repository.request_action.purchase.post

import android.util.Log
import androidx.navigation.Navigation
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.make_purchase.MakePurchaseFragment
import my.diploma.thursdaystore.retrofit.dto.purchases.post.MakePurchasesResponse
import retrofit2.Response

class MakePurchaseActionSuccess(private val f: MakePurchaseFragment): Consumer<Response<MakePurchasesResponse>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<MakePurchasesResponse>) {
        Log.d(TAG, "makePurchase Response = $t")
        t.body()?.let { response ->
            Log.d(TAG, "makePurchase Content = $response")
        }

        f.activity?.onBackPressed()
        Navigation.findNavController(f.requireView()).navigate(R.id.nav_purchases)
    }

}