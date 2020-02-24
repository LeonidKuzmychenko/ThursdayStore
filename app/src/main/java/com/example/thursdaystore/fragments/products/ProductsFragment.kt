package com.example.thursdaystore.fragments.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_products.*

class ProductsFragment : Fragment() {

    private lateinit var productsViewModel: ProductsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

        productsRecyclerView.layoutManager = GridLayoutManager(context, 2)

        productsViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            productsRecyclerView.adapter = ProductsAdapter(it)
        })
        productsViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    private fun init(bundle: Bundle) {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = "${it.title}: ${ProductsFragmentArgs.fromBundle(bundle).subCategoryId}"
        }
    }
}
