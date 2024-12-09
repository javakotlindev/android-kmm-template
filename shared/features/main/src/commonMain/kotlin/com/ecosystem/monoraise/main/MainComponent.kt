package com.ecosystem.monoraise.main

import kotlinx.coroutines.flow.StateFlow

interface MainComponent {
    val uiState: StateFlow<MainState>

    data class MainState(
        val titles: List<String> = listOf(),
        val loading: Boolean = false,
        val error: Boolean = false,
    )
}
