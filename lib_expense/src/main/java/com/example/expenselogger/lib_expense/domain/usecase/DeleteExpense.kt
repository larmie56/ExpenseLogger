package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.threading.AsyncExecutor
import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.usecase.base.AsyncParamUsecase
import javax.inject.Inject

public class DeleteExpense @Inject constructor(
    private val expenseRepository: ExpenseRepository,
    asyncExecutor: AsyncExecutor
) : AsyncParamUsecase<Long, Unit>(asyncExecutor) {

    override suspend fun execute(
        param: Long
    ): Unit = expenseRepository.deleteExpense(param)
}
