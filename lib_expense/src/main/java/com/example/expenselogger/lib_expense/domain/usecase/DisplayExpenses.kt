package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class DisplayExpenses(
    private val expenseContract: ExpenseContract
) {

    suspend fun displayExpenses(): List<Expense> {
        return expenseContract.getExpenses()
    }
}
