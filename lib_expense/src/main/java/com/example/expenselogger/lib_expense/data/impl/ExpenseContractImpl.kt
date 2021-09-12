package com.example.expenselogger.lib_expense.data.impl

import com.example.expenselogger.cache.repository.ExpenseRepository
import com.example.expenselogger.lib_expense.data.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense
import javax.inject.Inject

internal class ExpenseContractImpl @Inject constructor(
    private val expenseRepository: ExpenseRepository,
    private val expenseModelMapper: ExpenseModelMapper
) : ExpenseContract {
    override suspend fun insertExpense(expense: Expense): Long =
        expenseRepository.insertExpense(expenseModelMapper.mapFromModel(expense))

    override suspend fun updateExpense(expense: Expense) =
        expenseRepository.updateExpense(expenseModelMapper.mapFromModel(expense))

    override suspend fun getExpense(id: Long): Expense? =
        expenseRepository.getExpense(id)?.let { expenseModelMapper.mapToModel(it) }

    override suspend fun getExpenses(): List<Expense> =
        expenseModelMapper.mapToModelList(expenseRepository.getExpenses())

    override suspend fun deleteExpense(expense: Expense) =
        expenseRepository.deleteExpense(expense.id)
}
