package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class CreateExpense(
    private val expenseContract: ExpenseContract
) {

    suspend fun createExpense(expense: Expense) {
        expenseContract.saveExpense(expense)
    }
}
