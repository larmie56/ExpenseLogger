package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.threading.AsyncExecutor
import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense
import com.example.expenselogger.lib_expense.domain.usecase.base.AsyncParamUsecase
import javax.inject.Inject

public class InsertExpense @Inject constructor(
    private val expenseContract: ExpenseContract,
    asyncExecutor: AsyncExecutor
) : AsyncParamUsecase<Expense, Long>(asyncExecutor) {

    override suspend fun execute(
        param: Expense
    ): Long = expenseContract.insertExpense(param)
}
