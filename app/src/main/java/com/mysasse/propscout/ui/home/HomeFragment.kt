package com.mysasse.propscout.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.mysasse.propscout.R
import com.mysasse.propscout.databinding.FragmentHomeBinding
import com.mysasse.propscout.ui.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override fun getViewModel() = HomeViewModel::class.java

    override fun getFragmentView() = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.user.observe(viewLifecycleOwner, Observer {
            binding.user = it
        })
    }

}