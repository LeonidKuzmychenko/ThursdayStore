package my.diploma.thursdaystore.fragments.make_purchase

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.retrofit.dto.purchases.post.MakePurchaseRequest
import my.diploma.thursdaystore.utils.Language

class MakePurchaseFragment : Fragment() {

    private lateinit var viewModel: MakePurchaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        viewModel = ViewModelProvider(this).get(MakePurchaseViewModel::class.java)
        return inflater.inflate(R.layout.make_purchase_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_make_purchase_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.make_purchase_ok) {
            Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show()
            val purchase = MakePurchaseRequest(null, Language.getLanguage(), "address test", "type test")
            WebRepositoryActions.INSTANCE.makePurchase(purchase)
        }
        return super.onOptionsItemSelected(item)
    }
}