package my.diploma.thursdaystore.repository.request_action.locale

import android.util.Log
import io.reactivex.functions.Consumer

class GetLocaleActionError: Consumer<Throwable> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getLocale error", t)
    }

}