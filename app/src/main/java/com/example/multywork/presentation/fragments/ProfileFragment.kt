package com.example.multywork.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.multywork.databinding.FragmentProfileBinding
import com.example.multywork.presentation.viewmodels.ProfileViewModel
import com.example.multywork.presentation.viewmodels.ProfileViewModelFactory
import com.example.multywork.utils.App
import com.example.multywork.utils.Utils.openWebPage
import javax.inject.Inject


class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ProfileViewModelFactory

    private lateinit var viewModel: ProfileViewModel
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ProfileViewModel::class.java)
        viewModel.userProfile.observe(
            viewLifecycleOwner
        ) { userProfile ->
            (userProfile.firstName + " " + userProfile.lastName).also {
                binding.userName.text = it
            }
            binding.rating.rating = userProfile.rating.toFloat()
            binding.company.text = userProfile.company
            binding.position.text = userProfile.position
            binding.verificationIcon.isVisible = userProfile.verified.toBoolean()
        }
        binding.goToSiteButton.setOnClickListener {
            openWebPage(
                resources.getString(com.example.multywork.R.string.website_url),
                requireContext()
            )
        }
    }
}




