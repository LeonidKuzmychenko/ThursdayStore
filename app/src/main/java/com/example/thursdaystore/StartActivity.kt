package com.example.thursdaystore

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thursdaystore.repository.WebRepositoryActions
import com.example.thursdaystore.utils.PermissionManager
import com.example.thursdaystore.utils.SharedPreferencesManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class StartActivity : AppCompatActivity() {


    val TAG = this.javaClass.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        start()
    }

    private fun start(){
        if (checkPermissions()){
            startActivity()
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PermissionManager.INSTANCE.REQUEST_PERMISSION_MANAGER -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity()
                } else {
                    start()
                }
            }
        }
    }

    private fun checkPermissions() = PermissionManager.INSTANCE.check(
            listOf(
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET
            ), this)


    private fun startActivity(){
        SharedPreferencesManager.INSTANCE.init(this)

        GlobalScope.launch {
            WebRepositoryActions.INSTANCE.getUserData()

            Thread.sleep(5500)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }
}
