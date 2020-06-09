package my.diploma.thursdaystore.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.utils.Lines
import my.diploma.thursdaystore.utils.PermissionManager
import my.diploma.thursdaystore.utils.SharedPreferencesManager

class StartActivity : AppCompatActivity() {

    val TAG = this.javaClass.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        start()
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
        Lines.context = applicationContext
        SharedPreferencesManager.INSTANCE.init(this)
        WebRepositoryActions.INSTANCE.getLocale(this)
    }

    fun startMainActivity(){
        GlobalScope.launch {
            Thread.sleep(3500)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }

    private fun start(){
        if (checkPermissions()){
            startActivity()
        }
    }
}
