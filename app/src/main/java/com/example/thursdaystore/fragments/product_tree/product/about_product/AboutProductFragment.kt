package com.example.thursdaystore.fragments.product_tree.product.about_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R

class AboutProductFragment : Fragment() {

    private lateinit var aboutProductViewModel: AboutProductViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        aboutProductViewModel = ViewModelProvider(this).get(AboutProductViewModel::class.java)
        return inflater.inflate(R.layout.fragment_about_product, container, false)
    }
}
