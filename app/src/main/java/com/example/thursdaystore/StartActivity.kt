package com.example.thursdaystore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        GlobalScope.launch{
            delay(5000)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }
}
