package my.diploma.thursdaystore.repository.request_action.user.set

import android.app.Activity
import android.util.Log
import io.reactivex.functions.Consumer
import my.diploma.thursdaystore.activities.MainActivity
import my.diploma.thursdaystore.retrofit.dto.user.UserData
import my.diploma.thursdaystore.utils.SharedPreferencesManager
import retrofit2.Response

class SetUserDataActionSuccess(private val activity:Activity?): Consumer<Response<UserData>>{

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<UserData>) {
        Log.d(TAG, "getUserData Response = $t")
        Log.d(TAG, "getUserData Content = ${t.body()}")
        if (t.code() == 200){
            val user = t.body()
            SharedPreferencesManager.INSTANCE.setPersonName(user!!.name ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonLastName(user.lastName ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonPatronymic(user.patronymic ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonGender(user.gender ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonBirthDay(user.birthDay ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonPhone(user.phone ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonCity(user.city ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonAddress(user.address ?: "unknown")
            SharedPreferencesManager.INSTANCE.setPersonEmail(user.email ?: "unknown")
        }

        if (activity is MainActivity) activity.setNavViewUserName()

    }

}