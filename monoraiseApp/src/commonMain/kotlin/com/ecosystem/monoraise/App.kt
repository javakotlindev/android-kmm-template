package com.ecosystem.monoraise

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.ecosystem.monoraise.features.root.RootComponent
import com.ecosystem.monoraise.features.root.RootScreen

@Composable
fun App(component: RootComponent) {
    MaterialTheme {
        RootScreen(component)
    }
}
