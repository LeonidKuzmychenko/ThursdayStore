package my.diploma.thursdaystore.drawer.personal

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_person.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.utils.Lines
import my.diploma.thursdaystore.utils.SharedPreferencesManager

class PersonalFragment : Fragment() {

    private lateinit var personalViewModel: PersonalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        personalViewModel = ViewModelProvider(this).get(PersonalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_settings_title)
        }

        WebRepositoryActions.INSTANCE.getUserData()

        val sp = SharedPreferencesManager.INSTANCE
        personNameContent.text = sp.getPersonName()
        personLastNameContent.text = sp.getPersonLastName()
        personPatronymicContent.text = sp.getPersonPatronymic()
        personGenderContent.text = sp.getPersonGender()
        personBirthDayContent.text = sp.getPersonBirthDay()
        personPhoneContent.text = sp.getPersonPhone()
        personCityContent.text = sp.getPersonCity()
        personAddressContent.text = sp.getPersonAddress()
        personEmailContent.text = sp.getPersonEmail()
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