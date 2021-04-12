package com.example.android_mvvm_template

import android.os.Bundle
import com.example.android_mvvm_template.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
    override val viewModel: MainViewModel by viewModel()

    override fun onCreate(binding: ActivityMainBinding, savedInstanceState: Bundle?) {

    }

    override fun initBinding(binding: ActivityMainBinding) {
        binding.run {
            lifecycleOwner = this@MainActivity
        }
    }

    override fun subscribeViewModel(viewModel: MainViewModel) {
        viewModel.run {

        }
    }

}