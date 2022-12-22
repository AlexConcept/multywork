package com.example.offzmi.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.offzmi.domain.RequestViewModel
import com.example.offzmi.R
import com.example.offzmi.databinding.FragmentRequestBinding
import com.example.offzmi.utils.Utils.copyToClipboard

class RequestFragment : Fragment() {

    private lateinit var viewModel: RequestViewModel
    private var _binding: FragmentRequestBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRequestBinding.inflate(inflater, container, false)
        val root = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shareLinkButton.setOnClickListener {
            copyToClipboard(resources.getString(R.string.website_url), requireContext())
        }
    }
}