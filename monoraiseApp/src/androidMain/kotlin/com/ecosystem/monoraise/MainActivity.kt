package com.ecosystem.monoraise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import com.ecosystem.monoraise.features.root.RootComponentImpl
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rootComponent = RootComponentImpl(defaultComponentContext(), get())
        setContent {
            App(rootComponent)
        }
    }
}
