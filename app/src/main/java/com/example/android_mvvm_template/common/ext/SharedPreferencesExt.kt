package com.example.android_mvvm_template.common.ext

import android.content.SharedPreferences
import androidx.core.content.edit

fun SharedPreferences.putString(key: String, value: String?) {
    edit {
        putString(key, value)
    }
}

fun SharedPreferences.putInteger(key: String, value: Int) {
    edit {
        putInt(key, value)
    }
}

fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    edit {
        putBoolean(key, value)
    }
}