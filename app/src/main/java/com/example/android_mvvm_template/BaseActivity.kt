package com.example.android_mvvm_template

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<B : ViewDataBinding, VM : ViewModel>(@LayoutRes private val layoutRes: Int) :
    AppCompatActivity() {

    abstract val viewModel: VM

    private lateinit var binding: B

    abstract fun onCreate(binding: B, savedInstanceState: Bundle?)

    abstract fun initBinding(binding: B)

    abstract fun subscribeViewModel(viewModel: VM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        onCreate(binding, savedInstanceState)
        initBinding(binding)
        subscribeViewModel(viewModel)
    }


}