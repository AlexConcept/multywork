package com.example.offzmi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.offzmi.R

class WriteToUsFragment : Fragment() {

    companion object {
        fun newInstance() = WriteToUsFragment()
    }

    private lateinit var viewModel: WriteToUsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_write_to_us, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WriteToUsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}