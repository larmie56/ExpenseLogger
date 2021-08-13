package com.example.expenselogger.executor.threading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

public interface AsyncExecutor {
    public val main: CoroutineDispatcher
    public val io: CoroutineDispatcher
    public val default: CoroutineDispatcher
}

internal data class CoroutinesAsyncExecutor(
    override val main: CoroutineDispatcher = Dispatchers.Main,
    override val io: CoroutineDispatcher = Dispatchers.IO,
    override val default: CoroutineDispatcher = Dispatchers.Default
) : AsyncExecutor
