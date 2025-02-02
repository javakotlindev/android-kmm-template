package com.ecosystem.monoraise.common.ui.decompose

import org.koin.core.Koin
import org.koin.core.component.KoinComponent

class ComponentFactory(private val localKoin: Koin) : KoinComponent {

    override fun getKoin(): Koin = localKoin
}
