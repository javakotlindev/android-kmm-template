package com.ecosystem.monoraise.data.repositories

import com.ecosystem.monoraise.common.utils.KtResult
import com.ecosystem.monoraise.domain.repositories.TestRepository
import com.ecosystem.monoraise.remote.api.TestApi
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok

class TestRepositoryImpl(
    private val testApi: TestApi,
) : TestRepository {
    override suspend fun getTestList(): KtResult<List<String>, String?> {
        return kotlin.runCatching { testApi.getList() }.fold(
            onSuccess = { response -> Ok(List(10) { response.title }) },
            onFailure = { Err(it.message) }
        )
    }
}
