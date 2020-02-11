package com.example.thursdaystore.fragments.product_tree


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.thursdaystore.R
import com.example.thursdaystore.fragments.product_tree.product.AboutProductFragment
import com.example.thursdaystore.fragments.product_tree.product.ReviewsFragment
import com.example.thursdaystore.fragments.product_tree.product.SpecificationsFragment
import kotlinx.android.synthetic.main.fragment_product_tree.*

/**
 * A simple [Fragment] subclass.
 */
class ProductTreeFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(AboutProductFragment(), "AboutProductFragment")
        adapter.addFragment(SpecificationsFragment(), "SpecificationsFragment")
        adapter.addFragment(ReviewsFragment(), "ReviewsFragment")
        viewPager2.adapter = adapter
        tabLayout.setupWithViewPager(viewPager2)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_tree, container, false)
    }


}
