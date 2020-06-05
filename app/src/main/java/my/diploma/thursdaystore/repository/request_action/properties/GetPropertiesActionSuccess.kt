package my.diploma.thursdaystore.repository.request_action.properties

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.retrofit.dto.properties.PropertiesResponse
import retrofit2.Response

class GetPropertiesActionSuccess: Consumer<Response<List<PropertiesResponse>>> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<PropertiesResponse>>) {
        Log.d(TAG, "getProperties Response = $t")
        t.body()?.forEach { response ->
            Log.d(TAG, "getProperties Content = $response")
        }
    }
}