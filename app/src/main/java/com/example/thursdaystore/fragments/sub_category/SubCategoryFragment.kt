package com.example.thursdaystore.fragments.sub_category

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
import com.example.thursdaystore.drawer.category.CategoryAdapter
import kotlinx.android.synthetic.main.fragment_sub_category.*

class SubCategoryFragment : Fragment() {

    private lateinit var activity: OpenProducts
    private lateinit var subCategoryViewModel: SubCategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sub_category_next.setOnClickListener { activity.openProducts() }
        subCategoryRecyclerView.layoutManager = LinearLayoutManager(context)

        subCategoryViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            subCategoryRecyclerView.adapter = SubCategoryAdapter(it)
        })
        subCategoryViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        subCategoryViewModel = ViewModelProvider(this).get(SubCategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    override fun onAttach(context: Context) {
        if (context is OpenProducts) {
            activity = context
        } else throw ClassCastException("must be implements needed interface")
        super.onAttach(context)
    }

    interface OpenProducts {
        fun openProducts()
    }
}
