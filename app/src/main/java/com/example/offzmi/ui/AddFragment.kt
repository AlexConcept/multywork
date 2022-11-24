package com.example.offzmi.ui


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.offzmi.R
import com.example.offzmi.viewmodel.BottomNavAddViewModel

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: BottomNavAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_nav_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BottomNavAddViewModel::class.java)
        // TODO: Use the ViewModel
    }
}