package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.entity.ExpenseEntity

public interface ExpenseRepository {

    public suspend fun insertExpense(expenseEntity: ExpenseEntity): Long
    public suspend fun updateExpense(expenseEntity: ExpenseEntity)
    public suspend fun getExpense(id: Long): ExpenseEntity?
    public suspend fun getExpenses(): List<ExpenseEntity>
    public suspend fun deleteExpense(id: Long)
}
