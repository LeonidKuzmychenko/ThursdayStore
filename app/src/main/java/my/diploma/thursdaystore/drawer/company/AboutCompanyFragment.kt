package my.diploma.thursdaystore.drawer.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_company.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.utils.Lines

class AboutCompanyFragment : Fragment() {

    private lateinit var aboutCompanyViewModel: AboutCompanyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        aboutCompanyViewModel = ViewModelProvider(this).get(AboutCompanyViewModel::class.java)
        return inflater.inflate(R.layout.fragment_company, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_company_title)
        }

        text_company.text = Lines.get(R.string.fragment_company_text)
    }
}