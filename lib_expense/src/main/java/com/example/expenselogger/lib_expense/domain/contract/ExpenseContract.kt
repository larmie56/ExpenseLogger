package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.lib_expense.domain.model.Expense

public interface ExpenseContract {
    public suspend fun insertExpense(expense: Expense)
    public suspend fun updateExpense(expense: Expense)
    public suspend fun getExpense(id: Long): Expense?
    public suspend fun getExpenses(): List<Expense>
    public suspend fun deleteExpense(expense: Expense)
}
