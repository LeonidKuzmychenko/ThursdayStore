package my.diploma.thursdaystore.repository.request_action.cart

import android.util.Log
import io.reactivex.functions.Consumer

class GetCartActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getCart error", t)
    }

}