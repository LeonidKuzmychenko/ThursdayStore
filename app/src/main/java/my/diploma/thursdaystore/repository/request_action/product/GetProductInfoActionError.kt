package my.diploma.thursdaystore.repository.request_action.product

import android.util.Log
import io.reactivex.functions.Consumer

class GetProductInfoActionError: Consumer<Throwable> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getProductInfo error", t)
    }

}