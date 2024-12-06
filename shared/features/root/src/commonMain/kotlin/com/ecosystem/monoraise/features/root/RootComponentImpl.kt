package com.ecosystem.monoraise.features.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.ecosystem.monoraise.features.auth.AuthComponentImpl
import com.ecosystem.monoraise.features.root.RootComponent.Child
import com.ecosystem.monoraise.features.root.RootComponent.Config
import com.ecosystem.monoraise.features.root.RootComponent.Config.Auth
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer

class RootComponentImpl(
    componentContext: ComponentContext
) : ComponentContext by componentContext, RootComponent {
    private val navigation = StackNavigation<Config>()

    @OptIn(InternalSerializationApi::class)
    override val childStack = childStack(
        source = navigation,
        serializer = Config::class.serializer(),
        initialConfiguration = Auth,
        handleBackButton = true,
        childFactory = { configuration, componentContext ->
            when (configuration) {
                Auth -> {
                    Child.Auth(
                        component = AuthComponentImpl(
                            componentContext = componentContext
                        )
                    )
                }
            }
        }
    )
}
