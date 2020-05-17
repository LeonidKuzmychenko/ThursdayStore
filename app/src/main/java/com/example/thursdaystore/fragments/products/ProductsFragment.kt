package com.example.thursdaystore.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thursdaystore.R
import com.example.thursdaystore.repository.WebRepositoryActions
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : Fragment() {

    private lateinit var productsViewModel: ProductsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { bundle ->
            val id = ProductsFragmentArgs.fromBundle(bundle).subcategoryId
            val title = ProductsFragmentArgs.fromBundle(bundle).title

            (activity as AppCompatActivity).supportActionBar?.let { it.title = "${it.title}: $title" }
            productsRecyclerView.layoutManager = GridLayoutManager(context, 2)
            productsViewModel.listLiveData.observe(viewLifecycleOwner, ProductsLiveDataObserver(productsRecyclerView))
            productFilter.setOnClickListener(FilterButtonClickListener(title,id))

            if (ProductsFragmentArgs.fromBundle(bundle).isFilter) {
                Log.d("FILTER_TEST", "Filter value = true")
                WebRepositoryActions.INSTANCE.getProducts(id, productsViewModel.listLiveData)//TODO
            } else {
                Log.d("FILTER_TEST", "Filter value = false")
                WebRepositoryActions.INSTANCE.getProducts(id, productsViewModel.listLiveData)
            }

        } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

}
