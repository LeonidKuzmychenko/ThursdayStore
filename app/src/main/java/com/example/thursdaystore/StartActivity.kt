package com.example.thursdaystore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.thursdaystore.repository.WebRepositoryActions
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class StartActivity : AppCompatActivity() {


    val TAG = this.javaClass.canonicalName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        GlobalScope.launch {
//            delay(3000)

//            Log.d(TAG,"getCategories")
//            WebRepositoryActions.INSTANCE.getCategories("eng")
//            delay(3000)


//            Log.d(TAG,"getSubcategories")
//            WebRepositoryActions.INSTANCE.getSubcategories(1)
//            delay(3000)

//            Language.getLanguage()

//            Log.d(TAG,"getProducts")
//            WebRepositoryActions.INSTANCE.getProducts(1)
//            delay(3000)


            Log.d(TAG,"getFilter")
            WebRepositoryActions.INSTANCE.getFilter(1)
            delay(3000)


            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }
}
