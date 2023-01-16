package com.example.offzmi.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.offzmi.R
import com.example.offzmi.databinding.FragmentProfileBinding
import com.example.offzmi.domain.ProfileViewModel
import com.example.offzmi.utils.Utils.openWebPage
import de.hdodenhof.circleimageview.CircleImageView
import okio.ByteString
import okio.ByteString.Companion.decodeBase64

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by viewModels { ProfileViewModel.Factory }
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userProfile.observe(
            viewLifecycleOwner
        ) { userProfile ->
            (userProfile.records[0].fields.firstName + " " + userProfile.records[0].fields.lastName).also {
                binding.userName.text = it
            }
            binding.rating.rating = userProfile.records[0].fields.rating.toFloat()
            binding.company.text = userProfile.records[0].fields.company
            binding.position.text = userProfile.records[0].fields.position
            binding.verificationIcon.isVisible = userProfile.records[0].fields.verified.toBoolean()
        }
        binding.goToSiteButton.setOnClickListener {
            openWebPage(
                resources.getString(R.string.website_url),
                requireContext()
            )
        }
    }
}




