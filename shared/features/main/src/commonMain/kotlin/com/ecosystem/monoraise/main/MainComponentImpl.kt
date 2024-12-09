package com.ecosystem.monoraise.main

import com.arkivanov.decompose.ComponentContext
import com.ecosystem.monoraise.main.MainComponent.MainState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainComponentImpl(
    componentContext: ComponentContext,

    ) : ComponentContext by componentContext, MainComponent {
    override val uiState: StateFlow<MainState>
        field = MutableStateFlow(MainState())

}
