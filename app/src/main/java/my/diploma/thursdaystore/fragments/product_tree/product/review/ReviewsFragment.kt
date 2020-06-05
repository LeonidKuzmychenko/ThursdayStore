package my.diploma.thursdaystore.fragments.product_tree.product.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_reviews.*
import my.diploma.thursdaystore.R

class ReviewsFragment : Fragment() {

    private lateinit var reviewViewModel: ReviewViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reviewRecyclerView.layoutManager = LinearLayoutManager(context)

        reviewViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            reviewRecyclerView.adapter = ReviewAdapter(it)
        })
        reviewViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        reviewViewModel = ViewModelProvider(this).get(ReviewViewModel::class.java)
        return inflater.inflate(R.layout.fragment_reviews, container, false)
    }
}
