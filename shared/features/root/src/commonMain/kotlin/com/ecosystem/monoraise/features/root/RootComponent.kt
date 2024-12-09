package com.ecosystem.monoraise.features.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ecosystem.monoraise.features.auth.AuthComponent
import com.ecosystem.monoraise.main.MainComponent
import kotlinx.serialization.Serializable

interface RootComponent {

    val childStack: Value<ChildStack<Config, Child>>

    sealed class Child {
        class Auth(val component: AuthComponent) : Child()
        class Main(val component: MainComponent) : Child()
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object Auth : Config

        @Serializable
        data object Main : Config
    }
}