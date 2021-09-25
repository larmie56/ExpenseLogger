package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.threading.AsyncExecutor
import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.Expense
import com.example.expenselogger.lib_expense.domain.usecase.base.AsyncParamUsecase
import javax.inject.Inject

public class UpdateExpense @Inject constructor(
    private val expenseRepository: ExpenseRepository,
    asyncExecutor: AsyncExecutor
) : AsyncParamUsecase<Expense, Unit>(asyncExecutor) {

    override suspend fun execute(
        param: Expense
    ): Unit = expenseRepository.updateExpense(param)
}
