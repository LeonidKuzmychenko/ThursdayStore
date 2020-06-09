package my.diploma.thursdaystore.repository.request_action.purchase.get

import android.util.Log
import io.reactivex.functions.Consumer

class GetPurchasesActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getSubcategories error", t)
    }

}