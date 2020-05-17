package com.example.thursdaystore.drawer.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thursdaystore.R
import com.example.thursdaystore.repository.WebRepositoryActions
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryRecyclerView.layoutManager = LinearLayoutManager(context)

        categoryViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            categoryRecyclerView.adapter = CategoryAdapter(it)
        })

        WebRepositoryActions.INSTANCE.getCategories("eng", categoryViewModel.listLiveData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
}