package com.ecosystem.monoraise.remote.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class TestResponse(
    val id: String,
    val title: String
)
