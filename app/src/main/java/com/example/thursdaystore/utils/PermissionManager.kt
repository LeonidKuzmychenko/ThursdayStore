package com.example.thursdaystore.utils

import android.app.Activity
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.util.Log
import androidx.core.app.ActivityCompat

enum class PermissionManager {

    INSTANCE;

    private val TAG = "PERMISSION_MANAGER"

    val REQUEST_PERMISSION_MANAGER = 1

    fun check(permissions:List<String>, activity: Activity){
        val permissionsNew:MutableList<String> = mutableListOf()

        permissions.forEach {
            val state = ActivityCompat.checkSelfPermission(activity, it) != PERMISSION_GRANTED
            Log.d(TAG,"$it = $state")
            if (state) permissionsNew.add(it)
        }

        if (permissionsNew.isNotEmpty()){
            ActivityCompat.requestPermissions(activity, permissionsNew.toTypedArray(), REQUEST_PERMISSION_MANAGER)
        }
    }

}