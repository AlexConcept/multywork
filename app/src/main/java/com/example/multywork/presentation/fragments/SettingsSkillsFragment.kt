package com.example.multywork.presentation.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.domain.entity.Skill
import com.example.multywork.R
import com.example.multywork.databinding.FragmentSettingsSkillsBinding
import com.example.multywork.presentation.viewmodels.SettingsSkillsViewModel
import com.example.multywork.presentation.viewmodels.SettingsSkillsViewModelFactory
import com.example.multywork.utils.App
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class SettingsSkillsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: SettingsSkillsViewModelFactory

    private lateinit var viewModel: SettingsSkillsViewModel
    private var _binding: FragmentSettingsSkillsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSettingsSkillsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this,viewModelFactory)[SettingsSkillsViewModel::class.java]
        val view = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        view.visibility = View.GONE
        binding.nextButton.setOnClickListener { navigateToSettingsProject() }
        viewModel.skill.observe(
            viewLifecycleOwner){
            skill ->
            binding.designBtn.text = skill.skillName
        }
    }

    fun navigateToSettingsProject() {
        findNavController().navigate(R.id.action_settingsSkills_to_settingsProjectFragment)
    }
}