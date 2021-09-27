package com.example.expenselogger.lib_expense.data.impl

import com.example.expenselogger.cache.repository.ExpenseCache
import com.example.expenselogger.lib_expense.data.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.Expense
import javax.inject.Inject

internal class DefaultExpenseRepository @Inject constructor(
    private val expenseCache: ExpenseCache,
    private val expenseModelMapper: ExpenseModelMapper
) : ExpenseRepository {

    override suspend fun insertExpense(expense: Expense) {
        val cacheModel = expenseModelMapper.mapToCacheModel(expense)
        expenseCache.insertExpense(
            model = cacheModel
        )
    }

    override suspend fun updateExpense(expense: Expense) {
        val cacheModel = expenseModelMapper.mapToCacheModel(expense)
        expenseCache.updateExpense(model = cacheModel)
    }

    override suspend fun getExpense(id: Long): Expense? =
        expenseCache.getExpense(id)?.let { expenseModelMapper.mapToExpense(it) }

    override suspend fun getExpenses(): List<Expense> {
        val expenseCacheModel = expenseCache.getExpenses()
        return expenseModelMapper.mapToExpenseList(model = expenseCacheModel)
    }

    override suspend fun deleteExpense(id: Long) =
        expenseCache.deleteExpense(id = id)
}
