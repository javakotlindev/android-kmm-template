package com.ecosystem.monoraise.domain.repositories

import com.ecosystem.monoraise.common.utils.KtResult

interface TestRepository {
    suspend fun getTestList(): KtResult<List<String>, String?>
}
