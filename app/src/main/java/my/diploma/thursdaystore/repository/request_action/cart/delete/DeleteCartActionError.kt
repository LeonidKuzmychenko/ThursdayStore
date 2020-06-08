package my.diploma.thursdaystore.repository.request_action.cart.delete

import android.util.Log
import io.reactivex.functions.Consumer

class DeleteCartActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "deleteCart error", t)
    }

}