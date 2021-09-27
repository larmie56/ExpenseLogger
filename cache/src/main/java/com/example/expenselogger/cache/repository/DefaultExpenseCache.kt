package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.entity.ExpenseCacheModel
import javax.inject.Inject

internal class DefaultExpenseCache @Inject constructor(
    private val expenseDao: ExpenseDao
) : ExpenseCache {

    override suspend fun insertExpense(
        model: ExpenseCacheModel
    ): Long = expenseDao.insertExpense(model)

    override suspend fun updateExpense(
        model: ExpenseCacheModel
    ) = expenseDao.updateExpense(model)

    override suspend fun getExpense(
        id: Long
    ): ExpenseCacheModel? = expenseDao.getExpense(id)

    override suspend fun getExpenses(): List<ExpenseCacheModel> =
        expenseDao.getExpenses()

    override suspend fun deleteExpense(id: Long) {
        expenseDao.deleteExpense(id)
    }
}
