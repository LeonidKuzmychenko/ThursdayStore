package my.diploma.thursdaystore.fragments.product_tree

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_product_tree.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.fragments.product_tree.product.about_product.AboutProductFragment
import my.diploma.thursdaystore.fragments.product_tree.product.review.ReviewsFragment
import my.diploma.thursdaystore.fragments.product_tree.product.specifications.SpecificationsFragment

class ProductTreeFragment : Fragment() {

    private lateinit var productTreeViewModel: ProductTreeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

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

    private fun init(bundle: Bundle) {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = "${it.title}: ${ProductTreeFragmentArgs.fromBundle(bundle).productId}"
        }
    }
}
