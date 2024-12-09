package com.ecosystem.monoraise.main

import com.arkivanov.decompose.ComponentContext
import com.ecosystem.monoraise.domain.repositories.TestRepository
import com.ecosystem.monoraise.main.MainComponent.MainState
import com.github.michaelbull.result.fold
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainComponentImpl(
    componentContext: ComponentContext,
    private val repository: TestRepository,
) : ComponentContext by componentContext, MainComponent {

    private val _uiState = MutableStateFlow(MainState())
    override val uiState: StateFlow<MainState> = _uiState.asStateFlow()

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    init {
        scope.launch {
            _uiState.update { it.copy(loading = true) }
            repository.getTestList().fold(
                success = { _uiState.update { state -> state.copy(titles = it) } },
                failure = { _uiState.update { state -> state.copy(error = true) } }
            )
            _uiState.update { it.copy(loading = false) }
        }
    }
}
