package com.example.thursdaystore.drawer.personal

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thursdaystore.R

class PersonalFragment : Fragment() {

    private lateinit var personalViewModel: PersonalViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        personalViewModel = ViewModelProvider(this).get(PersonalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_person_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.person_ok) {
            Toast.makeText(context,"SAVE", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}