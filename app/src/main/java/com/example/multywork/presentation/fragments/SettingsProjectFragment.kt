package com.example.multywork.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.multywork.R
import com.example.multywork.databinding.FragmentSettingsProjectBinding
import com.example.multywork.databinding.FragmentSettingsSkillsBinding
import com.example.multywork.presentation.viewmodels.SettingsProjectViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsProjectFragment : Fragment() {

    private var _binding: FragmentSettingsProjectBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsProjectViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSettingsProjectBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsProjectViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.GONE

        binding.nextButton.setOnClickListener { navigateToSettingsSettingsCover() }
    }

    fun navigateToSettingsSettingsCover() {
        findNavController().navigate(R.id.action_settingsProjectFragment_to_settingsCoverFragment)
    }
}