package com.example.thursdaystore.fragments.products

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R
import com.example.thursdaystore.repository.WebRepositoryActions
import com.example.thursdaystore.retrofit.dto.filter.request.ApplyFilterRequest
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment : Fragment() {

    private lateinit var productsViewModel: ProductsViewModel
    private var filter: ApplyFilterRequest? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id: Long
        val title: String
        arguments.let {
            id = ProductsFragmentArgs.fromBundle(it!!).subcategoryId
            title = ProductsFragmentArgs.fromBundle(it).title
            filter = ProductsFragmentArgs.fromBundle(it).filterRequest
        }

        Log.d("FILTER_TEST", "Filter = ${filter.toString()}")

        (activity as AppCompatActivity).supportActionBar?.let { it.title = "${it.title}: $title" }

        productsViewModel.listLiveData.observe(
            viewLifecycleOwner,
            ProductsLiveDataObserver(productsRecyclerView)
        )
        productFilter.setOnClickListener(FilterButtonClickListener(title, id, filter))

        if (filter != null) {
            Log.d("FILTER_TEST", "Show with filter")
            Log.d("FILTER_TEST", "Body = ${Moshi.Builder().build().adapter(ApplyFilterRequest::class.java).toJson(filter)}")

            if (filter!!.filters.filter { it.parameters.isNotEmpty() }.isEmpty()){
                Log.d("FILTER_TEST", "Filter is empty")
                WebRepositoryActions.INSTANCE.getProducts(id, productsViewModel.listLiveData)
            }
            else{
                Log.d("FILTER_TEST", "Filter is not empty")
                WebRepositoryActions.INSTANCE.applyFilter(filter!!, productsViewModel.listLiveData)
            }
        }
        else {
            Log.d("FILTER_TEST", "Show without filter")
            WebRepositoryActions.INSTANCE.getProducts(id, productsViewModel.listLiveData)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

}
