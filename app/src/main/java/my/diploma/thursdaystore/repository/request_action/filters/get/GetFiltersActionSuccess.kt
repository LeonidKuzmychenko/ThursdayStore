package my.diploma.thursdaystore.repository.request_action.filters.get

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.fragments.filter.FilterFragment
import my.diploma.thursdaystore.retrofit.dto.filter.response.FilterItem
import retrofit2.Response

class GetFiltersActionSuccess(private val f: FilterFragment): Consumer<Response<FilterItem>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<FilterItem>) {
        Log.d(TAG, "getFilter Response = $t")
        t.body()?.properties!!.forEach { response ->
            Log.d(TAG, "getFilter Content = $response")
        }

        t.body()?.let {
            f.stopSkeleton()
            f.setFilterObserver()
            f.setFilterPriceText()
            f.setNestedScrollingEnabled()
            f.vm.filterUi.value = it
        }
    }

}