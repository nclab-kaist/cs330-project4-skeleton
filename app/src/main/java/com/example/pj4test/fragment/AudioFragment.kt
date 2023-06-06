package com.example.pj4test.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pj4test.ProjectConfiguration
import com.example.pj4test.audioInference.SnapClassifier
import com.example.pj4test.databinding.FragmentAudioBinding

class AudioFragment: Fragment(), SnapClassifier.DetectorListener {
    private val TAG = "AudioFragment"

    private var _fragmentAudioBinding: FragmentAudioBinding? = null

    private val fragmentAudioBinding
        get() = _fragmentAudioBinding!!

    // classifiers
    lateinit var snapClassifier: SnapClassifier

    // views
    lateinit var ampView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("create", "success")
        _fragmentAudioBinding = FragmentAudioBinding.inflate(inflater, container, false)

        return fragmentAudioBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ampView = fragmentAudioBinding.AmplitudeView

        snapClassifier = SnapClassifier()
        snapClassifier.initialize(requireContext())
        snapClassifier.setDetectorListener(this)
    }

    override fun onPause() {
        super.onPause()
        snapClassifier.stopInferencing()
    }

    override fun onResume() {
        super.onResume()
        snapClassifier.startInferencing()
    }

    override fun onResults(score: Float, db: Int) {
        activity?.runOnUiThread {
            ampView.text = "%3s ".format(db)
//            Log.d("result", "dB: ${ampView.text}")
            if (db > 20) {
                ampView.setTextColor(ProjectConfiguration.activeTextColor)
            } else {
                ampView.setTextColor(ProjectConfiguration.idleTextColor)
            }
        }
    }
}