package com.ecosystem.monoraise.features.auth.sms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ecosystem.monoraise.common.ui.Res
import com.ecosystem.monoraise.common.ui.compose_multiplatform
import com.ecosystem.monoraise.common.ui.widgets.MRButton
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun SmsScreen(component: SmsComponent) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Sms") })
        }
    ) {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: Sms")
                    MRButton(
                        text = "Back",
                        onClick = component::onBackClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                    MRButton(
                        text = "Confirm sms",
                        onClick = component::onConfirmClick,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewSms() {
    MaterialTheme {
        SmsScreen(FakeSmsComponent())
    }
}
