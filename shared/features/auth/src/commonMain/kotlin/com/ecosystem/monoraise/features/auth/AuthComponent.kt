package com.ecosystem.monoraise.features.auth

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ecosystem.monoraise.features.auth.login.LoginComponent
import com.ecosystem.monoraise.features.auth.sms.SmsComponent
import kotlinx.serialization.Serializable

interface AuthComponent {
    val childStack: Value<ChildStack<Config, Child>>

    sealed class Child {
        internal class Login(val component: LoginComponent) : Child()
        internal class Sms(val component: SmsComponent) : Child()
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object Login : Config

        @Serializable
        data object Sms : Config
    }
}
