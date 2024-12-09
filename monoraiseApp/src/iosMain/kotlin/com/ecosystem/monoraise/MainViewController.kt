package com.ecosystem.monoraise

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.ApplicationLifecycle
import com.ecosystem.monoraise.features.root.RootComponentImpl

fun MainViewController() = ComposeUIViewController {
    App(
        remember {
            RootComponentImpl(
                DefaultComponentContext(ApplicationLifecycle()),
                DiHelperComponent().componentFactory
            )
        }
    )
}
