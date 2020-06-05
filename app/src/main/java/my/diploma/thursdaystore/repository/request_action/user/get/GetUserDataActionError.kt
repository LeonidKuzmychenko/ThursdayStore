package my.diploma.thursdaystore.repository.request_action.user.get

import android.util.Log
import io.reactivex.functions.Consumer

class GetUserDataActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getUserData error", t)
    }

}