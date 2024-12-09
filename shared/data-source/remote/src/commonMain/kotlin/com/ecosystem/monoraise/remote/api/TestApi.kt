package com.ecosystem.monoraise.remote.api

import com.ecosystem.monoraise.remote.dto.response.TestResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class TestApi(
    private val httpClient: HttpClient,
) {
    suspend fun getList(): TestResponse {
        return httpClient.get("https://jsonplaceholder.typicode.com/todos/1")
            .body<TestResponse>()
    }
}
