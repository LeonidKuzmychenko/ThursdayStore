package my.diploma.thursdaystore.fragments.person_change

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_person_change.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.repository.WebRepositoryActions
import my.diploma.thursdaystore.retrofit.dto.user.UserData
import my.diploma.thursdaystore.utils.SharedPreferencesManager


class PersonChangeFragment : Fragment() {

    private lateinit var viewModel: PersonChangeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_person_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sp = SharedPreferencesManager.INSTANCE
        personEditNameContent.setText(getNullFormatText(sp.getPersonName()))
        personEditLastNameContent.setText(getNullFormatText(sp.getPersonLastName()))
        personEditPatronymicContent.setText(getNullFormatText(sp.getPersonPatronymic()))
        personEditGenderContent.setText(getNullFormatText(sp.getPersonGender()))
        personEditBirthDayContent.setText(getNullFormatText(sp.getPersonBirthDay()))
        personEditPhoneContent.setText(getNullFormatText(sp.getPersonPhone()))
        personEditCityContent.setText(getNullFormatText(sp.getPersonCity()))
        personEditAddressContent.setText(getNullFormatText(sp.getPersonAddress()))
        personEditEmailContent.setText(getNullFormatText(sp.getPersonEmail()))
    }

    private fun getNullFormatText(v: String) = if (v == "unknown") null else v

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PersonChangeViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_person_change_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.person_change_ok) {
            Toast.makeText(context, "SAVE", Toast.LENGTH_SHORT).show()
            val userData = UserData(
                null,
                null,
                personEditNameContent.text.toString(),
                personEditLastNameContent.text.toString(),
                personEditPatronymicContent.text.toString(),
                personEditEmailContent.text.toString(),
                personEditGenderContent.text.toString(),
                personEditBirthDayContent.text.toString(),
                personEditPhoneContent.text.toString(),
                personEditCityContent.text.toString(),
                personEditAddressContent.text.toString()
            )

            val user = Moshi.Builder().build().adapter(UserData::class.java).toJson(userData)
            Log.d("TEST_PERSON_DATA", "Sent Content =  $user")

            WebRepositoryActions.INSTANCE.setUserData(activity,userData)
        }
        return super.onOptionsItemSelected(item)
    }

}