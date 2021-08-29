package com.example.expenselogger.cache.repository

import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.entity.ExpenseEntity
import javax.inject.Inject

internal class ExpenseRepositoryImpl @Inject constructor(private val expenseDao: ExpenseDao) :
    ExpenseRepository {

    override fun insertExpense(expenseEntity: ExpenseEntity) {
        expenseDao.insertExpense(expenseEntity)
    }

    override fun updateExpense(expenseEntity: ExpenseEntity) {
        expenseDao.updateExpense(expenseEntity)
    }

    override fun getExpense(id: Long): ExpenseEntity? {
        return expenseDao.getExpense(id)
    }

    override fun getExpenses(): List<ExpenseEntity> {
        return expenseDao.getExpenses()
    }

    override fun deleteExpense(id: Long) {
        expenseDao.deleteExpense(id)
    }
}
