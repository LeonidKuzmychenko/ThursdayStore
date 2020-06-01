package com.example.thursdaystore.fragments.person_change

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R
import com.example.thursdaystore.repository.WebRepositoryActions
import com.example.thursdaystore.retrofit.dto.user.UserData
import com.example.thursdaystore.utils.SharedPreferencesManager
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.fragment_person_change.*


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

        personEditNameContent.setText(SharedPreferencesManager.INSTANCE.getPersonName())
        personEditLastNameContent.setText(SharedPreferencesManager.INSTANCE.getPersonLastName())
        personEditPatronymicContent.setText(SharedPreferencesManager.INSTANCE.getPersonPatronymic())
        personEditGenderContent.setText(SharedPreferencesManager.INSTANCE.getPersonGender())
        personEditBirthDayContent.setText(SharedPreferencesManager.INSTANCE.getPersonBirthDay())
        personEditPhoneContent.setText(SharedPreferencesManager.INSTANCE.getPersonPhone())
        personEditCityContent.setText(SharedPreferencesManager.INSTANCE.getPersonCity())
        personEditAddressContent.setText(SharedPreferencesManager.INSTANCE.getPersonAddress())
        personEditEmailContent.setText(SharedPreferencesManager.INSTANCE.getPersonEmail())
    }

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
                personEditGenderContent.text.toString(),
                personEditBirthDayContent.text.toString(),
                personEditPhoneContent.text.toString(),
                personEditCityContent.text.toString(),
                personEditAddressContent.text.toString(),
                personEditEmailContent.text.toString()
            )

            val moshi: Moshi = Moshi.Builder().build()
            val adapter: JsonAdapter<UserData> = moshi.adapter(UserData::class.java)
            val movie = adapter.toJson(userData)

            Log.d("TEST_PERSON_DATA", movie)

            WebRepositoryActions.INSTANCE.setUserData(userData)
        }
        return super.onOptionsItemSelected(item)
    }

}