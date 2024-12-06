package com.ecosystem.monoraise.features.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.ecosystem.monoraise.features.auth.AuthScreen
import com.ecosystem.monoraise.features.root.RootComponent.Child.Auth

@Composable
fun RootScreen(component: RootComponent) {
    Children(
        stack = component.childStack
    ) { stack ->
        when (val child = stack.instance) {
            is Auth -> AuthScreen(child.component)
        }
    }
}