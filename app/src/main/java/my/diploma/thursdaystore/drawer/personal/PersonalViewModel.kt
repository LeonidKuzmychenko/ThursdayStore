package my.diploma.thursdaystore.drawer.personal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is personal Fragment" }
}