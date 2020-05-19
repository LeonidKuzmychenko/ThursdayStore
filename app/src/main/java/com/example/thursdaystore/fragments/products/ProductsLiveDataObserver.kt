package com.example.thursdaystore.fragments.products

import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.thursdaystore.fragments.products.adapter.ProductsAdapter
import com.example.thursdaystore.retrofit.dto.product.ProductResponse

class ProductsLiveDataObserver(private val rv: RecyclerView) : Observer<List<ProductResponse>> {

    override fun onChanged(it: List<ProductResponse>) {
        Log.d("ProductsAdapterData","Filtered data = $it")
        rv.adapter = ProductsAdapter(it)
    }
}