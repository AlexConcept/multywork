package com.example.offzmi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class bottom_nav_requestFragment : Fragment() {

    companion object {
        fun newInstance() = bottom_nav_requestFragment()
    }

    private lateinit var viewModel: BottomNavRequestViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_nav_request2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomNavRequestViewModel::class.java)
        // TODO: Use the ViewModel
    }

}