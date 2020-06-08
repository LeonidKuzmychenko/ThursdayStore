package my.diploma.thursdaystore.repository.request_action.favorites

import android.util.Log
import io.reactivex.functions.Consumer

class GetFavoritesActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getFavorites error", t)
    }

}