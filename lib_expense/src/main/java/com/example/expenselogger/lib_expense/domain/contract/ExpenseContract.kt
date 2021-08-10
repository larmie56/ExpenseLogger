package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.lib_expense.domain.model.Expense

interface ExpenseContract {
    fun saveExpense(expense: Expense)
    fun getExpense(id: Long): Expense?
    fun getExpenses(): List<Expense>
    fun deleteExpense(expense: Expense)
}
