package my.diploma.thursdaystore.fragments.product_tree.product.specifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_specifications.*
import my.diploma.thursdaystore.R

class SpecificationsFragment : Fragment() {

    private lateinit var specificationsViewModel: SpecificationsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        specificationRecyclerView.layoutManager = LinearLayoutManager(context)

        specificationsViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            specificationRecyclerView.adapter = SpecificationsAdapter(it)
        })
        specificationsViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        specificationsViewModel = ViewModelProvider(this).get(SpecificationsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_specifications, container, false)
    }
}
