package com.ecosystem.monoraise

import com.ecosystem.monoraise.common.ui.decompose.ComponentFactory
import com.ecosystem.monoraise.data.di.repositoryModule
import com.ecosystem.monoraise.remote.di.networkModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(networkModule, repositoryModule)
        koin.apply { declare(ComponentFactory(this)) }
    }
}
