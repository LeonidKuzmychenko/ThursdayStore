package my.diploma.thursdaystore.repository.request_action.filters.apply

import android.util.Log
import io.reactivex.functions.Consumer

class ApplyFilterActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "applyFilter error", t)
    }

}