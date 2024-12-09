package com.ecosystem.monoraise.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun MainScreen(component: MainComponent) {
    val uiState = component.uiState.collectAsStateWithLifecycle().value
    Scaffold { paddings ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings)
        ) {
            when {
                uiState.loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                uiState.error -> {
                    Text(
                        text = "Error data fetch",
                        modifier = Modifier.align(Alignment.BottomCenter)
                    )
                }

                else -> {
                    LazyColumn {
                        items(uiState.titles) {
                            Text(text = it)
                        }
                    }
                }
            }
        }
    }
}
