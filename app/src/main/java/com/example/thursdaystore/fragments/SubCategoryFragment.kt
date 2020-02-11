package com.example.thursdaystore.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_sub_category.*
import java.lang.ClassCastException

class SubCategoryFragment : Fragment() {

    private lateinit var activity: OpenProducts


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sub_category_next.setOnClickListener { activity.openProducts() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }


    interface OpenProducts {
        fun openProducts()
    }

    override fun onAttach(context: Context) {
        if (context is OpenProducts) {
            activity = context
        } else throw ClassCastException("must be implements needed interface")
        super.onAttach(context)
    }
}
