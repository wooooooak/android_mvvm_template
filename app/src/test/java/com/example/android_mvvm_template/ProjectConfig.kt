package com.example.android_mvvm_template

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.spec.IsolationMode

object ProjectConfig : AbstractProjectConfig() {
    override val isolationMode: IsolationMode = IsolationMode.InstancePerLeaf
}