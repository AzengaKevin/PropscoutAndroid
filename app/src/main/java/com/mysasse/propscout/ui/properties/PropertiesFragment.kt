package com.mysasse.propscout.ui.properties

import android.os.Bundle
import androidx.lifecycle.Observer
import com.mysasse.propscout.R
import com.mysasse.propscout.databinding.FragmentPropertiesBinding
import com.mysasse.propscout.ui.BaseFragment

class PropertiesFragment : BaseFragment<FragmentPropertiesBinding, PropertiesViewModel>() {

    private val propertiesAdapter by lazy { PropertiesAdapter() }

    override fun getViewModel() = PropertiesViewModel::class.java

    override fun getFragmentView() = R.layout.fragment_properties

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.quotesRecyclerView.adapter = propertiesAdapter

        viewModel.properties.observe(viewLifecycleOwner, Observer {
            propertiesAdapter.properties = it
        })
    }


}