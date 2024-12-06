package com.ecosystem.monoraise.features.auth

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.ecosystem.monoraise.features.auth.AuthComponent.Child.Login
import com.ecosystem.monoraise.features.auth.AuthComponent.Child.Sms
import com.ecosystem.monoraise.features.auth.login.LoginScreen
import com.ecosystem.monoraise.features.auth.sms.SmsScreen

@Composable
fun AuthScreen(component: AuthComponent) {
    Children(
        stack = component.childStack
    ) { stack ->
        when (val child = stack.instance) {
            is Login -> LoginScreen(child.component)
            is Sms -> SmsScreen(child.component)
        }
    }
}
