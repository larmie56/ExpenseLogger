package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.threading.AsyncExecutor
import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.Expense
import com.example.expenselogger.lib_expense.domain.usecase.base.AsyncUsecase
import javax.inject.Inject

public class GetExpenses @Inject constructor(
    expenseRepository: ExpenseRepository,
    asyncExecutor: AsyncExecutor
) : AsyncUsecase<List<Expense>>(
    expenseRepository::getExpenses,
    asyncExecutor
)
