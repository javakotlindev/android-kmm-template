package com.ecosystem.monoraise.features.auth.login

import com.arkivanov.decompose.ComponentContext

internal class LoginComponentImpl(
    componentContext: ComponentContext,
    private val onNavigateSms: () -> Unit
) : ComponentContext by componentContext, LoginComponent {
    override fun onSmsClick() {
        onNavigateSms()
    }
}
