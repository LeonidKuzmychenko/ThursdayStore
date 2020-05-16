package com.example.thursdaystore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.thursdaystore.repository.WebRepositoryActions
import com.example.thursdaystore.repository.WebRepositoryRequests
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionError
import com.example.thursdaystore.repository.request_action.categories.GetCategoriesActionSuccess
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionError
import com.example.thursdaystore.repository.request_action.filters.GetFiltersActionSuccess
import com.example.thursdaystore.repository.request_action.products.GetProductsActionError
import com.example.thursdaystore.repository.request_action.products.GetProductsActionSuccess
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionError
import com.example.thursdaystore.repository.request_action.subcategories.GetSubcategoriesActionSuccess
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        GlobalScope.launch {
            WebRepositoryActions.INSTANCE.getCategories("eng")
            delay(1000)
            WebRepositoryActions.INSTANCE.getSubcategories(1)
            delay(1000)
            WebRepositoryActions.INSTANCE.getProducts(1)
            delay(1000)
            WebRepositoryActions.INSTANCE.getFilter(1, "eng")
            delay(1000)
            startActivity(Intent(this@StartActivity, MainActivity::class.java))
            finish()
        }
    }
}
