package com.example.expenselogger.lib_expense.data.impl

import com.example.expenselogger.cache.repository.ExpenseCacheRepository
import com.example.expenselogger.lib_expense.data.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense
import javax.inject.Inject

internal class ExpenseContractImpl @Inject constructor(
    private val expenseCacheRepository: ExpenseCacheRepository,
    private val expenseModelMapper: ExpenseModelMapper
) : ExpenseContract {
    override suspend fun insertExpense(expense: Expense) {
        expenseCacheRepository.insertExpense(expenseModelMapper.mapFromModel(expense))
    }

    override suspend fun updateExpense(expense: Expense) =
        expenseCacheRepository.updateExpense(expenseModelMapper.mapFromModel(expense))

    override suspend fun getExpense(id: Long): Expense? =
        expenseCacheRepository.getExpense(id)?.let { expenseModelMapper.mapToModel(it) }

    override suspend fun getExpenses(): List<Expense> =
        expenseModelMapper.mapToModelList(expenseCacheRepository.getExpenses())

    override suspend fun deleteExpense(expense: Expense) =
        expenseCacheRepository.deleteExpense(expense.id)
}
