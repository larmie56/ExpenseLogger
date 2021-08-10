package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class DeleteExpense(
    private val expenseContract: ExpenseContract
) {

    suspend fun deleteExpense(expense: Expense) {
        expenseContract.deleteExpense(expense)
    }
}
