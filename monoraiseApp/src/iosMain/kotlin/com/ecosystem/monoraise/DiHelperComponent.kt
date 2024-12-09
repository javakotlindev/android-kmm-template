package com.ecosystem.monoraise

import com.ecosystem.monoraise.common.ui.decompose.ComponentFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DiHelperComponent : KoinComponent {
    val componentFactory by inject<ComponentFactory>()
}
