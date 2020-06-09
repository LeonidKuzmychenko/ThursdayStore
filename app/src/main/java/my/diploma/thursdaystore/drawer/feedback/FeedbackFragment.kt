package my.diploma.thursdaystore.drawer.feedback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_feedback.*
import my.diploma.thursdaystore.R
import my.diploma.thursdaystore.utils.Lines

class FeedbackFragment : Fragment() {

    private lateinit var feedbackViewModel: FeedbackViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        feedbackViewModel = ViewModelProvider(this).get(FeedbackViewModel::class.java)
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.let {
            it.title = Lines.get(R.string.fragment_feedback_title)
        }

        text_feedback.text = Lines.get(R.string.fragment_feedback_text)
    }
}