package com.example.multywork.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.multywork.R
import com.example.multywork.databinding.FragmentInfoBinding
import com.example.multywork.utils.Utils.openWebPage


class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            infoFragment = this@InfoFragment
        }

        binding.faqButton.setOnClickListener {
            openWebPage(
                resources.getString(R.string.website_url),
                requireContext()
            )
        }
        binding.privacyPolicy.setOnClickListener {
            openWebPage(
                resources.getString(R.string.privacy_policy_url),
                requireContext()
            )
        }
    }

 fun writeToUs () {
     findNavController().navigate(R.id.action_InfoFragment_to_WriteToUsFragment)
 }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}