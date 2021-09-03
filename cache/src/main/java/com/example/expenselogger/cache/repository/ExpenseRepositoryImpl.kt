package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.entity.ExpenseEntity
import javax.inject.Inject

internal class ExpenseRepositoryImpl @Inject constructor(
    private val expenseDao: ExpenseDao
) : ExpenseRepository {

    override suspend fun insertExpense(
        expenseEntity: ExpenseEntity
    ): Long = expenseDao.insertExpense(expenseEntity)

    override suspend fun updateExpense(expenseEntity: ExpenseEntity) {
        expenseDao.updateExpense(expenseEntity)
    }

    override suspend fun getExpense(
        id: Long
    ): ExpenseEntity? = expenseDao.getExpense(id)

    override suspend fun getExpenses(): List<ExpenseEntity> = expenseDao.getExpenses()

    override suspend fun deleteExpense(id: Long) {
        expenseDao.deleteExpense(id)
    }
}
