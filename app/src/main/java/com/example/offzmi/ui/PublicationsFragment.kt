package com.example.offzmi.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.offzmi.viewmodel.BottomNavPublishesViewModel
import com.example.offzmi.R

class PublicationsFragment : Fragment() {

    companion object {
        fun newInstance() = PublicationsFragment()
    }

    private lateinit var viewModel: BottomNavPublishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_nav_publishes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomNavPublishesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}