package com.example.thursdaystore.repository.request_action.filters.get

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.thursdaystore.retrofit.dto.filter.response.FilterItem
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetFiltersActionSuccess(private val liveData:MutableLiveData<FilterItem>): Consumer<Response<FilterItem>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<FilterItem>) {
        Log.d(TAG, "getFilter Response = $t")
        t.body()?.properties!!.forEach { response ->
            Log.d(TAG, "getFilter Content = $response")
        }

        liveData.value = t.body()
    }

}