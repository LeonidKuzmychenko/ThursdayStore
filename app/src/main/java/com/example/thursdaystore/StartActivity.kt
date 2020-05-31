package com.example.thursdaystore

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.thursdaystore.utils.PermissionManager
import com.example.thursdaystore.utils.SharedPreferencesManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class StartActivity : AppCompatActivity() {


    val TAG = this.javaClass.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        PermissionManager.INSTANCE.check(
            listOf(
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET
            ), this)

        SharedPreferencesManager.INSTANCE.init(this)

        GlobalScope.launch {
            Thread.sleep(5000)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var granted = true
        if (requestCode == PermissionManager.INSTANCE.REQUEST_PERMISSION_MANAGER) {
            // Результат полученного разрешения на внешнее хранение
            Log.i(TAG, "Got response for external storage permission request.");

            // Проверяем, все ли разрешения получены
            if (grantResults.isNotEmpty()) {
                grantResults.forEach { result ->
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        granted = false
                    }
                }
            }
        } else {
            granted = false;
        }

    }
}
