package com.example.thursdaystore.drawer.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    private lateinit var activity: OpenSubcategory
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_next.setOnClickListener { activity.openSubcategory() }

        categoryRecyclerView.layoutManager = LinearLayoutManager(context)

        categoryViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            categoryRecyclerView.adapter = CategoryAdapter(it)
        })
        categoryViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onAttach(context: Context) {
        if (context is OpenSubcategory){
            activity = context
        }
        else throw ClassCastException("must be implements needed interface")
        super.onAttach(context)
    }

    interface OpenSubcategory{
        fun openSubcategory()
    }
}