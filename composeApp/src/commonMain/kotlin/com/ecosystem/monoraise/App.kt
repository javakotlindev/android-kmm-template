package com.ecosystem.monoraise

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ecosystem.monoraise.features.auth.ComposeScreen

@Composable
fun App() {
    MaterialTheme {
        ComposeScreen(Modifier)
    }
}
