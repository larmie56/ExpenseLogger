package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.entity.ExpenseCacheModel

public interface ExpenseCache {
    public suspend fun insertExpense(model: ExpenseCacheModel): Long
    public suspend fun updateExpense(model: ExpenseCacheModel)
    public suspend fun getExpense(id: Long): ExpenseCacheModel?
    public suspend fun getExpenses(): List<ExpenseCacheModel>
    public suspend fun deleteExpense(id: Long)
}
