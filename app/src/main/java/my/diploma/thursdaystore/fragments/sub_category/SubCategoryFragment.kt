package my.diploma.thursdaystore.fragments.sub_category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen
import com.ethanhua.skeleton.Skeleton
import kotlinx.android.synthetic.main.fragment_sub_category.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import kotlin.properties.Delegates

class SubCategoryFragment : Fragment() {

    lateinit var subCategoryViewModel: SubCategoryViewModel
    private var id by Delegates.notNull<Long>()
    private lateinit var skeleton: RecyclerViewSkeletonScreen

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startSkeleton()

        arguments?.let { init(it) } ?: run {
            Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
        }

        subCategoryRecyclerView.layoutManager = LinearLayoutManager(context)

        subCategoryViewModel.listLiveData.observe(
            viewLifecycleOwner,
            Observer { subCategoryRecyclerView.adapter = SubCategoryAdapter(it) })

        WebRepositoryActions.INSTANCE.getSubcategories(this, id)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subCategoryViewModel = ViewModelProvider(this).get(SubCategoryViewModel::class.java)
        return inflater.inflate(R.layout.fragment_sub_category, container, false)
    }

    private fun init(bundle: Bundle) {
        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = SubCategoryFragmentArgs.fromBundle(bundle).title
        }

        id = SubCategoryFragmentArgs.fromBundle(bundle).categoryId
    }

    fun startSkeleton(){
        skeleton = Skeleton.bind(subCategoryRecyclerView).adapter(SubCategoryAdapter(listOf())).load(R.layout.fragment_category_list_skeleton).show()
    }

    fun stopSkeleton(){
        skeleton.hide()
    }

}
