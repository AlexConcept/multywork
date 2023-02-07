package com.example.multywork.presentation.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.multywork.R
import com.example.multywork.databinding.FragmentSettingsCoverBinding
import com.example.multywork.presentation.viewmodels.SettingsCoverViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class SettingsCoverFragment : Fragment() {

    private var _binding: FragmentSettingsCoverBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsCoverViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSettingsCoverBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SettingsCoverViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.GONE

        binding.nextButton.setOnClickListener { navigateToHome() }
    }

    override fun onPause() {
        super.onPause()
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.VISIBLE
    }

    fun navigateToHome() {
        findNavController().navigate(R.id.action_settingsCoverFragment_to_PublicationsFragment)
    }
}