package my.diploma.thursdaystore.drawer.purchases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_purchases.*
import my.diploma.thursdaystore.R

class PurchasesFragment : Fragment() {

    private lateinit var purchasesViewModel: PurchasesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        purchasesRecyclerView.layoutManager = LinearLayoutManager(context)

        purchasesViewModel.listLiveData.observe(viewLifecycleOwner, Observer {
            purchasesRecyclerView.adapter = PurchasesAdapter(it)
        })
        purchasesViewModel.listLiveData.value = mutableListOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        purchasesViewModel = ViewModelProvider(this).get(PurchasesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_purchases, container, false)
    }
}