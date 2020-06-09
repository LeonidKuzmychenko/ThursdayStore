package my.diploma.thursdaystore.repository.request_action.locale

import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.activities.StartActivity
import my.diploma.thursdaystore.retrofit.dto.locale.Locale
import my.diploma.thursdaystore.utils.Lines
import retrofit2.Response

class GetLocaleActionSuccess(private val activity:StartActivity?): Consumer<Response<List<Locale>>> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<List<Locale>>) {
        Log.d(TAG, "getLocale Response = $t")
        t.body()?.forEach { line ->
            Log.d(TAG, "getLocale Content = $line")
            Lines.set(line.key,line.value)
        }

        activity?.startMainActivity()
    }
}