package my.diploma.thursdaystore.drawer.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import my.diploma.thursdaystore.R

class AboutCompanyFragment : Fragment() {

    private lateinit var aboutCompanyViewModel: AboutCompanyViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        aboutCompanyViewModel = ViewModelProvider(this).get(AboutCompanyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_company, container, false)
        val textView: TextView = root.findViewById(R.id.text_company)
        aboutCompanyViewModel.text.observe(this, Observer { textView.text = it })
        return root
    }
}