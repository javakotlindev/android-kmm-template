package com.ecosystem.monoraise.features.auth

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.ecosystem.monoraise.features.auth.AuthComponent.Child
import com.ecosystem.monoraise.features.auth.AuthComponent.Config
import com.ecosystem.monoraise.features.auth.AuthComponent.Config.Login
import com.ecosystem.monoraise.features.auth.AuthComponent.Config.Sms
import com.ecosystem.monoraise.features.auth.login.LoginComponentImpl
import com.ecosystem.monoraise.features.auth.sms.SmsComponentImpl
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.serializer

class AuthComponentImpl(
    componentContext: ComponentContext,
    private val onNavigateMain: () -> Unit,
) : ComponentContext by componentContext, AuthComponent {

    private val navigation = StackNavigation<Config>()

    @OptIn(InternalSerializationApi::class)
    override val childStack = childStack(
        source = navigation,
        serializer = Config::class.serializer(),
        initialConfiguration = Login,
        handleBackButton = true,
        childFactory = { config, componentContext ->
            when (config) {
                is Login -> {
                    Child.Login(
                        component = LoginComponentImpl(
                            componentContext = componentContext,
                            onNavigateSms = { navigation.pushNew(Sms) }
                        )
                    )
                }

                is Sms -> {
                    Child.Sms(
                        component = SmsComponentImpl(
                            componentContext = componentContext,
                            onNavigateBack = navigation::pop,
                            onNavigateMain = onNavigateMain
                        )
                    )
                }
            }
        }
    )
}
