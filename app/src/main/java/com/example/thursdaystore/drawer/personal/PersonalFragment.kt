package com.example.thursdaystore.drawer.personal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.thursdaystore.R
import com.example.thursdaystore.utils.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_person.*

class PersonalFragment : Fragment() {

    private lateinit var personalViewModel: PersonalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        personalViewModel = ViewModelProvider(this).get(PersonalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personNameContent.text = SharedPreferencesManager.INSTANCE.getPersonName()
        personLastNameContent.text = SharedPreferencesManager.INSTANCE.getPersonLastName()
        personPatronymicContent.text = SharedPreferencesManager.INSTANCE.getPersonPatronymic()
        personGenderContent.text = SharedPreferencesManager.INSTANCE.getPersonGender()
        personBirthDayContent.text = SharedPreferencesManager.INSTANCE.getPersonBirthDay()
        personPhoneContent.text = SharedPreferencesManager.INSTANCE.getPersonPhone()
        personCityContent.text = SharedPreferencesManager.INSTANCE.getPersonCity()
        personAddressContent.text = SharedPreferencesManager.INSTANCE.getPersonAddress()
        personEmailContent.text = SharedPreferencesManager.INSTANCE.getPersonEmail()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_person_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.person_ok) {
            val action = PersonalFragmentDirections.actionNavPersonalToPersonChangeFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return super.onOptionsItemSelected(item)
    }
}