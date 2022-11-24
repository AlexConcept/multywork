package com.example.offzmi.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.offzmi.utils.Utils.openWebPage
import android.view.ViewGroup
import com.example.offzmi.viewmodel.BottomNavProfileViewModel
import com.example.offzmi.R
import com.example.offzmi.databinding.FragmentBottomNavProfileBinding

class ProfileFragment : Fragment() {


    private lateinit var viewModel: BottomNavProfileViewModel
    private var _binding: FragmentBottomNavProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomNavProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToSiteButton.setOnClickListener {
            openWebPage(
                resources.getString(R.string.base_url),
                requireContext()
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomNavProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}