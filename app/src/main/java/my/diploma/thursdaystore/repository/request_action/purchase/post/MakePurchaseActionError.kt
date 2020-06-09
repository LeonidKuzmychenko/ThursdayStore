package my.diploma.thursdaystore.repository.request_action.purchase.post

import android.util.Log
import io.reactivex.functions.Consumer

class MakePurchaseActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "makePurchase error", t)
    }

}