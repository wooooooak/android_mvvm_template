package com.example.android_mvvm_template

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding>(layoutRes: Int) : Fragment(layoutRes) {
    private lateinit var binding: B

    abstract fun onViewCreated(binding: B, savedInstanceState: Bundle?)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind<B>(view) ?: return
        onViewCreated(binding, savedInstanceState)
    }
}