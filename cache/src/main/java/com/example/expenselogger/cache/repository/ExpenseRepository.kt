package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.entity.ExpenseEntity

public interface ExpenseRepository {

    public fun insertExpense(expenseEntity: ExpenseEntity)
    public fun updateExpense(expenseEntity: ExpenseEntity)
    public fun getExpense(id: Long): ExpenseEntity?
    public fun getExpenses(): List<ExpenseEntity>
    public fun deleteExpense(id: Long)
}
