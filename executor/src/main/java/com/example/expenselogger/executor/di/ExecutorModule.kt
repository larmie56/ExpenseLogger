package com.example.expenselogger.executor.di

import com.example.expenselogger.executor.threading.AsyncExecutor
import com.example.expenselogger.executor.threading.CoroutinesAsyncExecutor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal interface ExecutorModule {

    @get:[Binds Singleton]
    val CoroutinesAsyncExecutor.executor: AsyncExecutor
}
