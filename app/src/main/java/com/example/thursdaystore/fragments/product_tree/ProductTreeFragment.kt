package com.example.thursdaystore.fragments.product_tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R
import com.example.thursdaystore.fragments.product_tree.product.about_product.AboutProductFragment
import com.example.thursdaystore.fragments.product_tree.product.review.ReviewsFragment
import com.example.thursdaystore.fragments.product_tree.product.specifications.SpecificationsFragment
import kotlinx.android.synthetic.main.fragment_product_tree.*

class ProductTreeFragment : Fragment() {

    private lateinit var productTreeViewModel: ProductTreeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(AboutProductFragment(), "AboutProductFragment")
        adapter.addFragment(SpecificationsFragment(), "SpecificationsFragment")
        adapter.addFragment(ReviewsFragment(), "ReviewsFragment")
        viewPager2.adapter = adapter
        tabLayout.setupWithViewPager(viewPager2)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        productTreeViewModel = ViewModelProvider(this).get(ProductTreeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_product_tree, container, false)
    }
}
