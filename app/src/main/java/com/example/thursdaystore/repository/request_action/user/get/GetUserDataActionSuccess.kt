package com.example.thursdaystore.repository.request_action.user.get

import android.util.Log
import com.example.thursdaystore.retrofit.dto.user.UserData
import com.example.thursdaystore.utils.SharedPreferencesManager
import io.reactivex.functions.Consumer
import retrofit2.Response

class GetUserDataActionSuccess: Consumer<Response<UserData>> {

    val TAG = this.javaClass.simpleName

    override fun accept(t: Response<UserData>) {
        Log.d(TAG, "getUserData Response = $t")
        Log.d(TAG, "getUserData Content = ${t.body()}")
        Log.d(TAG, "getUserData Content = ${t.message()}")

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

}