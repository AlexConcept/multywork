package com.example.multywork.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multywork.R
import com.example.multywork.presentation.viewmodels.SettingsProjectViewModel

class SettingsProjectFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsProjectFragment()
    }

    private lateinit var viewModel: SettingsProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_settings_project, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsProjectViewModel::class.java)
        // TODO: Use the ViewModel
    }

}