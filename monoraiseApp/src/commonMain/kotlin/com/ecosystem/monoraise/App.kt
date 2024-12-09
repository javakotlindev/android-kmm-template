package com.ecosystem.monoraise

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.ecosystem.monoraise.common.ui.decompose.ComponentFactory
import com.ecosystem.monoraise.data.di.repositoryModule
import com.ecosystem.monoraise.features.root.RootComponent
import com.ecosystem.monoraise.features.root.RootScreen
import com.ecosystem.monoraise.remote.di.networkModule
import org.koin.compose.KoinApplication

@Composable
fun App(component: RootComponent) {
    KoinApplication(
        application = {
            modules(networkModule, repositoryModule)
            koin.apply { declare(ComponentFactory(this)) }
        }
    ) {
        MaterialTheme {
            RootScreen(component)
        }
    }
}
