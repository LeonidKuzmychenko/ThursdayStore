package com.example.thursdaystore.utils

import android.util.Log
import java.util.*

class Language {

    companion object{
        fun getLanguage(): String {
            val lang = Locale.getDefault().isO3Language
            Log.d("Language", "Language = $lang")
            return lang
        }
    }
}