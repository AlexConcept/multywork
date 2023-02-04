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
import com.example.multywork.databinding.FragmentWelcomeBinding
import com.example.multywork.presentation.viewmodels.WelcomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class WelcomeFragment : Fragment() {
    private var _binding: FragmentWelcomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: WelcomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val root = binding.root
        return root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.GONE

        binding.welcomeFragment = this@WelcomeFragment
    }

    fun navigateToSettings() {
        findNavController().navigate(R.id.action_welcomeFragment_to_settingsSkills)
    }
}