package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class GetExpense(
    private val expenseContract: ExpenseContract
) {

    fun getExpense(id: Long): Expense? {
        return expenseContract.getExpense(id)
    }
}
