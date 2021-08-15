package com.example.expenselogger.lib_expense.domain.usecase.base

import com.example.expenselogger.executor.threading.AsyncExecutor
import kotlinx.coroutines.withContext

public abstract class AsyncUsecase<out T>(
    private val work: suspend () -> T,
    private val asyncExecutor: AsyncExecutor
) {

    public suspend operator fun invoke(): T = withContext(asyncExecutor.io) {
        work()
    }
}
