package my.diploma.thursdaystore.repository.request_action.user.set

import android.util.Log
import io.reactivex.functions.Consumer

class SetUserDataActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "setUserData error", t)
    }

}