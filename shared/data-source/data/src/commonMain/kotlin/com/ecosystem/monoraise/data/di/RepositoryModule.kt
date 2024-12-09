package com.ecosystem.monoraise.data.di

import com.ecosystem.monoraise.data.repositories.TestRepositoryImpl
import com.ecosystem.monoraise.domain.repositories.TestRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<TestRepository> { TestRepositoryImpl(get()) }
}
