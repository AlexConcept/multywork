package com.example.offzmi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.offzmi.R
import com.example.offzmi.databinding.FragmentInfoBinding
import com.example.offzmi.utils.Utils.openWebPage
import com.example.offzmi.viewmodel.InfoViewModel


class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoViewModel
    private var _binding: FragmentInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.faqButton.setOnClickListener {
            openWebPage(
                resources.getString(R.string.base_url),
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
