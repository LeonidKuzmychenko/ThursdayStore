package com.example.thursdaystore.drawer.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_category.*
import java.lang.ClassCastException

class CategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category_next.setOnClickListener { activity.openSubcategory() }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_category, container, false)
        val textView: TextView = root.findViewById(R.id.text_category)
        categoryViewModel.text.observe(this, Observer { textView.text = it })
        return root
    }

    private lateinit var activity: OpenSubcategory

    interface OpenSubcategory{
        fun openSubcategory()
    }

    override fun onAttach(context: Context) {
        if (context is OpenSubcategory){
            activity = context
        }
        else throw ClassCastException("must be implements needed interface")
        super.onAttach(context)
    }
}