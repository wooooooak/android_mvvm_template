package com.example.android_mvvm_template

import android.app.Application
import com.example.android_mvvm_template.di.getNetworkModule
import com.example.android_mvvm_template.di.getPresentationModule
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    getNetworkModule("www.example.com"),
                    getPresentationModule()
                )
            )
        }

        Logger.addLogAdapter(
            AndroidLogAdapter(
                PrettyFormatStrategy.newBuilder()
                    .showThreadInfo(true)
                    .methodCount(2)
                    .build()
            )
        )
    }
}