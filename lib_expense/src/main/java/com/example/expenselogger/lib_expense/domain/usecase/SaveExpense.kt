package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class SaveExpense(
    private val expenseContract: ExpenseContract
) {

    suspend fun saveExpense(expense: Expense) {
        expenseContract.saveExpense(expense)
    }
}
