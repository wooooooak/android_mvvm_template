package com.example.android_mvvm_template

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel>(layoutRes: Int) : Fragment(layoutRes) {

    abstract val viewModel: VM

    private lateinit var binding: B

    abstract fun onViewCreated(binding: B, savedInstanceState: Bundle?)

    abstract fun initBinding(binding: B)

    abstract fun subscribeViewModel(viewModel: VM)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view) ?: return
        onViewCreated(binding, savedInstanceState)
        initBinding(binding)
        subscribeViewModel(viewModel)
    }
}