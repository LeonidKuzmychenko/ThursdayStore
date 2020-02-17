package com.example.thursdaystore.fragments.sub_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_sub_category.*

class SubCategoryFragment : Fragment() {

    private lateinit var subCategoryViewModel: SubCategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

        sub_category_next.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.productsFragment))
        subCategoryRecyclerView.layoutManager = LinearLayoutManager(context)

        subCategoryViewModel.listLiveData.observe(
            viewLifecycleOwner,
            Observer { subCategoryRecyclerView.adapter = SubCategoryAdapter(it) })

        subCategoryViewModel.listLiveData.value =
            mutableListOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subCategoryViewModel = ViewModelProvider(this).get(SubCategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    private fun init(bundle: Bundle) {
        sub_category_next.text = SubCategoryFragmentArgs.fromBundle(bundle).categoryId.toString()
    }
}
