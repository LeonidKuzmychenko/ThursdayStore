package my.diploma.thursdaystore.repository.request_action.cart.add

import android.util.Log
import io.reactivex.functions.Consumer

class AddCartActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "addCart error", t)
    }

}