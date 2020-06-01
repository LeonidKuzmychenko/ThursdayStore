package com.example.thursdaystore.utils

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

    fun setMacAddress(value:String) = pref.edit().putString(APP_MAC_ARRDESS, value).apply()

    fun setPersonName(value:String) = pref.edit().putString(APP_PERSON_NAME, value).apply()
    fun setPersonLastName(value:String) = pref.edit().putString(APP_PERSON_LAST_NAME, value).apply()
    fun setPersonPatronymic(value:String) = pref.edit().putString(APP_PERSON_PATRONYMIC, value).apply()
    fun setPersonGender(value:String) = pref.edit().putString(APP_PERSON_GENDER, value).apply()
    fun setPersonBirthDay(value:String) = pref.edit().putString(APP_PERSON_BIRTH_DAY, value).apply()
    fun setPersonPhone(value:String) = pref.edit().putString(APP_PERSON_PHONE, value).apply()
    fun setPersonCity(value:String) = pref.edit().putString(APP_PERSON_CITY, value).apply()
    fun setPersonAddress(value:String) = pref.edit().putString(APP_PERSON_ADDRESS, value).apply()
    fun setPersonEmail(value:String) = pref.edit().putString(APP_PERSON_EMAIL, value).apply()

//-------------------------------------------

    fun getMacAddress() = pref.getString(APP_MAC_ARRDESS, "02:00:00:00:00:00")!!

    fun getPersonName() = pref.getString(APP_PERSON_NAME, "unknown")!!
    fun getPersonLastName() = pref.getString(APP_PERSON_LAST_NAME, "unknown")!!
    fun getPersonPatronymic() = pref.getString(APP_PERSON_PATRONYMIC, "unknown")!!
    fun getPersonGender() = pref.getString(APP_PERSON_GENDER, "unknown")!!
    fun getPersonBirthDay() = pref.getString(APP_PERSON_BIRTH_DAY, "unknown")!!
    fun getPersonPhone() = pref.getString(APP_PERSON_PHONE, "unknown")!!
    fun getPersonCity() = pref.getString(APP_PERSON_CITY, "unknown")!!
    fun getPersonAddress() = pref.getString(APP_PERSON_ADDRESS, "unknown")!!
    fun getPersonEmail() = pref.getString(APP_PERSON_EMAIL, "unknown")!!



}