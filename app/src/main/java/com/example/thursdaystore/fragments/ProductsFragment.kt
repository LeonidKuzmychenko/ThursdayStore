package com.example.thursdaystore.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.thursdaystore.R
import kotlinx.android.synthetic.main.fragment_products.*
import java.lang.ClassCastException

/**
 * A simple [Fragment] subclass.
 */
class ProductsFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        products_next.setOnClickListener { activity.openProductTree() }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    private lateinit var activity: OpenProductTree

    interface OpenProductTree {
        fun openProductTree()
    }

    override fun onAttach(context: Context) {
        if (context is OpenProductTree) {
            activity = context
        } else throw ClassCastException("must be implements needed interface")
        super.onAttach(context)
    }

}
