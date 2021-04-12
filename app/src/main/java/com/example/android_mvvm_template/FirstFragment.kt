package com.example.android_mvvm_template

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.android_mvvm_template.databinding.FragmentFirstBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class FirstFragment : BaseFragment<FragmentFirstBinding, MainViewModel>(R.layout.fragment_first) {
    override val viewModel: MainViewModel by sharedViewModel()

    override fun onViewCreated(binding: FragmentFirstBinding, savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }
    }

    override fun initBinding(binding: FragmentFirstBinding) {
        binding.run {
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun subscribeViewModel(viewModel: MainViewModel) {
    }

}
