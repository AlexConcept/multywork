package com.example.multywork.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multywork.presentation.viewmodels.Add2ViewModel
import com.example.multywork.R

class AddFragment2 : Fragment() {

    companion object {
        fun newInstance() = AddFragment2()
    }

    private lateinit var viewModel: Add2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(Add2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}