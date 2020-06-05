package my.diploma.thursdaystore.drawer.company

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutCompanyViewModel : ViewModel() {
    val text: LiveData<String> = MutableLiveData<String>().apply { value = "This is company Fragment" }
}