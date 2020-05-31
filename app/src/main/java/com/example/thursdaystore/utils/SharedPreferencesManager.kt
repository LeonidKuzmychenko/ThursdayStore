package com.example.thursdaystore.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

enum class SharedPreferencesManager {
    INSTANCE;
    val APP_PREFERENCES = "mysettings"

    val APP_MAC_ARRDESS = "mac_address"
    lateinit var pref: SharedPreferences

    fun init(context: Context) {
        pref = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        set(MacAddress.INSTANCE.get(context))
    }

    fun set(address:String) = pref.edit().putString(APP_MAC_ARRDESS, address).apply()

    fun get() = pref.getString(APP_MAC_ARRDESS, "02:00:00:00:00:00")



}