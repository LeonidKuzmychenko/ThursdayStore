package com.example.thursdaystore.repository.request_action.products

import android.util.Log
import io.reactivex.functions.Consumer

class GetProductsActionError: Consumer<Throwable>{

    val TAG = this.javaClass.canonicalName

    override fun accept(t: Throwable?) {
        Log.d(TAG, "getProducts error", t)
    }

}