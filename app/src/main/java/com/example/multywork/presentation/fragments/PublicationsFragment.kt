package com.example.multywork.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multywork.domain.PubliсationsViewModel
import com.example.multywork.R

class PublicationsFragment : Fragment() {

    companion object {
        fun newInstance() = PublicationsFragment()
    }

    private lateinit var viewModel: PubliсationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_publishes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PubliсationsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}