package com.ecosystem.monoraise.features.auth.sms

import com.arkivanov.decompose.ComponentContext

internal class SmsComponentImpl(
    componentContext: ComponentContext,
    private val onNavigateBack: () -> Unit
) : ComponentContext by componentContext, SmsComponent {

    override fun onBackClick() {
        onNavigateBack()
    }
}
