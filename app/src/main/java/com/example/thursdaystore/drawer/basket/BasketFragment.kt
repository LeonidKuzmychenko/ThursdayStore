package com.example.thursdaystore.drawer.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thursdaystore.R
import com.example.thursdaystore.drawer.category.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_basket.*
import kotlinx.android.synthetic.main.fragment_category.*

class BasketFragment : Fragment() {

    private lateinit var basketViewModel: BasketViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        basketRecyclerView.layoutManager = LinearLayoutManager(context)

        basketViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            basketRecyclerView.adapter = BasketAdapter(it)
        })
        basketViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        basketViewModel = ViewModelProvider(this).get(BasketViewModel::class.java)
        return inflater.inflate(R.layout.fragment_basket, container, false)
    }
}