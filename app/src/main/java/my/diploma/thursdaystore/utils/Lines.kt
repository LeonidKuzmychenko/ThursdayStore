package my.diploma.thursdaystore.utils

import android.content.Context

class Lines {

    companion object {
        lateinit var context: Context

        private val lines: MutableMap<String, String> = HashMap()

        fun get(key: Int) = lines[context.getString(key)]!!

        fun set(key: String, value: String) {
            lines[key] = value
        }
    }


}