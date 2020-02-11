package com.example.thursdaystore.drawer.purchases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R

class PurchasesFragment : Fragment() {

    private lateinit var purchasesViewModel: PurchasesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        purchasesViewModel = ViewModelProvider(this).get(PurchasesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_purchases, container, false)
        val textView: TextView = root.findViewById(R.id.text_purchases)
        purchasesViewModel.text.observe(this, Observer { textView.text = it })
        return root
    }
}