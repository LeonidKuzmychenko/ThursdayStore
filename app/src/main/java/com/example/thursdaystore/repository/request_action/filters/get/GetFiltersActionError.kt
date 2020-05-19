package com.example.thursdaystore.repository.request_action.filters.get

import android.util.Log
import io.reactivex.functions.Consumer

class GetFiltersActionError: Consumer<Throwable>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getFilter error", t)
    }

}