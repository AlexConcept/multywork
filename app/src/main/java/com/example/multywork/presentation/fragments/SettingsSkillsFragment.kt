package com.example.multywork.presentation.fragments

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.multywork.R
import com.example.multywork.databinding.FragmentSettingsSkillsBinding
import com.example.multywork.presentation.viewmodels.SettingsSkillsViewModel
import com.example.multywork.presentation.viewmodels.SettingsSkillsViewModelFactory
import com.example.multywork.utils.App
import com.example.multywork.utils.Utils.base64ToBitmap
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch
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
        viewModel = ViewModelProvider(this, viewModelFactory)[SettingsSkillsViewModel::class.java]

        val bottomNavBar = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
        bottomNavBar.visibility = View.GONE


        val buttonNext = requireActivity().findViewById<AppCompatButton>(R.id.next_button)
        buttonNext.visibility = View.GONE

        val buttonArray = arrayOf(
            binding.designBtn,
            binding.statsBtn,
            binding.motionBtn,
            binding.pmBtn,
            binding.photoBtn,
            binding.webBtn,
            binding.compArchBtn,
            binding.graphDesignBtn,
            binding.prodManBtn,
            binding.teamLeadBtn,
            binding.dataCleanBtn,
            binding.dubbingActBtn,
            binding.marketBtn,
            binding.emailMarkBtn,
            binding.textDrawBtn,
            binding.dataAnalyticsBtn,
            binding.copywriterBtn,
            binding.brandManBtn,
            binding.qaBtn,
            binding.artBtn,
            binding.contentBtn,
            binding.marketingBtn,
            binding.finBtn,
            binding.softwareDevelopBtn,
            binding.uiDesignBtn,
            binding.targetingBtn,
            binding.videoMakingBtn,
            binding.dataScienceBtn,
            binding.managementBtn,
            binding.smmBtn,
            binding.mathBtn,
        )

        binding.nextButton.setOnClickListener { navigateToSettingsProject() }

        for (i in buttonArray) {
            i.setOnClickListener {
                val selected = it.isSelected
                it.isSelected = !selected

                when (selected) {
                    false -> buttonNext.visibility = View.VISIBLE
                    true -> buttonNext.visibility = View.GONE
                }
            }


        }

        viewModel.skills.observe(viewLifecycleOwner) {
            for (i in buttonArray.indices) {
                buttonArray[i].text = it.find { it.id == i + 1 }?.skillName
            }

            lifecycleScope.launch {
                for (i in buttonArray.indices) {
                    val skill = it.find { it.id == i + 1 } ?: continue
                    val bitmap = base64ToBitmap(skill.skillIconBase64, requireContext())
                    val drawable = BitmapDrawable(resources, bitmap)
                    buttonArray[i].setCompoundDrawablesWithIntrinsicBounds(
                        null,
                        drawable,
                        null,
                        null
                    )
                }
            }
        }
    }


    fun navigateToSettingsProject() {
        findNavController().navigate(R.id.action_settingsSkills_to_settingsProjectFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
