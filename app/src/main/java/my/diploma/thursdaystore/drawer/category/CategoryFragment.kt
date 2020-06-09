package my.diploma.thursdaystore.drawer.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_category.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.utils.Lines

class CategoryFragment : Fragment() {

    private lateinit var categoryViewModel: CategoryViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_category_title)
        }

        categoryViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            categoryRecyclerView.adapter = CategoryAdapter(it)
        })

        WebRepositoryActions.INSTANCE.getCategories(categoryViewModel.listLiveData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        categoryViewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_category, container, false)
    }
}