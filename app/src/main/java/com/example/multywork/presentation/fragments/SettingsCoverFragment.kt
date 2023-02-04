package com.example.multywork.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multywork.R
import com.example.multywork.presentation.viewmodels.SettingsCoverViewModel

class SettingsCoverFragment : Fragment() {

    companion object {
        fun newInstance() = SettingsCoverFragment()
    }

    private lateinit var viewModel: SettingsCoverViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_settings_cover, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsCoverViewModel::class.java)
        // TODO: Use the ViewModel
    }

}