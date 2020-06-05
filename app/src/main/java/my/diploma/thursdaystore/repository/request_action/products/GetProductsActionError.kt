package my.diploma.thursdaystore.repository.request_action.products

import android.util.Log
import io.reactivex.functions.Consumer

class GetProductsActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getProducts error", t)
    }

}