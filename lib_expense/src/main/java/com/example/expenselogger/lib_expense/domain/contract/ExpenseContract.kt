package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.lib_expense.domain.model.Expense

internal interface ExpenseContract {
    fun saveExpenseEntry(expense: Expense)
    fun getExpenseEntry(): Expense?
    fun getExpenses(): List<Expense>
    fun deleteExpenseEntry(expense: Expense)
}
