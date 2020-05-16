package com.example.thursdaystore.repository.request_action.subcategories

import android.util.Log
import io.reactivex.functions.Consumer

class GetSubcategoriesActionError: Consumer<Throwable>{

    val TAG = this.javaClass.canonicalName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getSubcategories error", t)
    }

}