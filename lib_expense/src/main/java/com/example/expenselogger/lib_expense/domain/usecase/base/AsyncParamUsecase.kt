package com.example.expenselogger.lib_expense.domain.usecase.base

import com.example.expenselogger.executor.threading.AsyncExecutor
import kotlinx.coroutines.withContext

public abstract class AsyncParamUsecase<in P, out T>(
    private val asyncExecutor: AsyncExecutor
) {

    protected abstract suspend fun execute(param: P): T

    public suspend operator fun invoke(param: P): T = withContext(asyncExecutor.io) {
        execute(param)
    }
}
