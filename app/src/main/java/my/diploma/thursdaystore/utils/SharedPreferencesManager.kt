package my.diploma.thursdaystore.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

enum class SharedPreferencesManager {

    INSTANCE;

    val APP_PREFERENCES = "mysettings"

    val APP_MAC_ARRDESS = "mac_address"

    val APP_PERSON_NAME = "person_name"
    val APP_PERSON_LAST_NAME = "person_last_name"
    val APP_PERSON_PATRONYMIC = "person_patronymic"
    val APP_PERSON_GENDER = "person_gender"
    val APP_PERSON_BIRTH_DAY = "person_birth_day"
    val APP_PERSON_PHONE = "person_phone"
    val APP_PERSON_CITY = "person_city"
    val APP_PERSON_ADDRESS = "person_address"
    val APP_PERSON_EMAIL = "person_email"

    lateinit var pref: SharedPreferences

    fun init(context: Context) {
        pref = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        setMacAddress(MacAddress.INSTANCE.get(context))
    }

    fun setMacAddress(value:String) = pref.edit().putString(APP_MAC_ARRDESS, value).commit()

    fun setPersonName(value:String) = pref.edit().putString(APP_PERSON_NAME, value).commit()
    fun setPersonLastName(value:String) = pref.edit().putString(APP_PERSON_LAST_NAME, value).commit()
    fun setPersonPatronymic(value:String) = pref.edit().putString(APP_PERSON_PATRONYMIC, value).commit()
    fun setPersonGender(value:String) = pref.edit().putString(APP_PERSON_GENDER, value).commit()
    fun setPersonBirthDay(value:String) = pref.edit().putString(APP_PERSON_BIRTH_DAY, value).commit()
    fun setPersonPhone(value:String) = pref.edit().putString(APP_PERSON_PHONE, value).commit()
    fun setPersonCity(value:String) = pref.edit().putString(APP_PERSON_CITY, value).commit()
    fun setPersonAddress(value:String) = pref.edit().putString(APP_PERSON_ADDRESS, value).commit()
    fun setPersonEmail(value:String) = pref.edit().putString(APP_PERSON_EMAIL, value).commit()

//-------------------------------------------

    fun getMacAddress() = pref.getString(APP_MAC_ARRDESS, "02:00:00:00:00:00")!!

    fun getPersonName() = pref.getString(APP_PERSON_NAME, "")!!
    fun getPersonLastName() = pref.getString(APP_PERSON_LAST_NAME, "")!!
    fun getPersonPatronymic() = pref.getString(APP_PERSON_PATRONYMIC, "")!!
    fun getPersonGender() = pref.getString(APP_PERSON_GENDER, "")!!
    fun getPersonBirthDay() = pref.getString(APP_PERSON_BIRTH_DAY, "")!!
    fun getPersonPhone() = pref.getString(APP_PERSON_PHONE, "")!!
    fun getPersonCity() = pref.getString(APP_PERSON_CITY, "")!!
    fun getPersonAddress() = pref.getString(APP_PERSON_ADDRESS, "")!!
    fun getPersonEmail() = pref.getString(APP_PERSON_EMAIL, "")!!

}