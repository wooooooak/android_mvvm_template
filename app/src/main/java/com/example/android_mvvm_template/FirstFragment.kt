package com.example.android_mvvm_template

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.android_mvvm_template.databinding.FragmentFirstBinding


class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {
    private lateinit var binding: FragmentFirstBinding

    override fun onViewCreated(binding: FragmentFirstBinding, savedInstanceState: Bundle?) {
        this.binding = binding

        binding.button.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
            findNavController().navigate(action)
        }
    }
}