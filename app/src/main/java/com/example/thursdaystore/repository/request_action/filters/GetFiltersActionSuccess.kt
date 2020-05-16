package com.example.thursdaystore.repository.request_action.filters

import android.util.Log
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetFiltersActionSuccess: Consumer<Response<List<FilterResponse>>>{

    val TAG = this.javaClass.canonicalName

    override fun accept(t: Response<List<FilterResponse>>) {
        Log.d(TAG, "getFilter Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getFilter Content = $response")
        }
    }

}