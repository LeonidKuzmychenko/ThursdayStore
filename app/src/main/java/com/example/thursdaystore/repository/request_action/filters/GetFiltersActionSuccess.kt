package com.example.thursdaystore.repository.request_action.filters

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.retrofit.dto.filter.FilterResponse
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetFiltersActionSuccess(private val liveData:MutableLiveData<List<FilterResponse>>): Consumer<Response<List<FilterResponse>>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<FilterResponse>>) {
        Log.d(TAG, "getFilter Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getFilter Content = $response")
        }

        liveData.value = t.body()
    }

}