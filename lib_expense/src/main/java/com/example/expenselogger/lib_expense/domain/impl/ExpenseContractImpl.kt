package com.example.expenselogger.lib_expense.domain.impl

import com.example.expenselogger.cache.repository.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.model.Expense
import javax.inject.Inject

internal class ExpenseContractImpl @Inject constructor(
    private val expenseRepository: ExpenseRepository,
    private val expenseModelMapper: ExpenseModelMapper
) : ExpenseContract {
    override suspend fun saveExpense(expense: Expense) {
        if (expense.id <= 0L) {
            expenseRepository.insertExpense(expenseModelMapper.mapFromModel(expense))
        } else {
            expenseRepository.updateExpense(expenseModelMapper.mapFromModel(expense))
        }
    }

    override suspend fun getExpense(id: Long): Expense? =
        expenseRepository.getExpense(id)?.let { expenseModelMapper.mapToModel(it) }

    override suspend fun getExpenses(): List<Expense> =
        expenseModelMapper.mapToModelList(expenseRepository.getExpenses())

    override suspend fun deleteExpense(expense: Expense) =
        expenseRepository.deleteExpense(expense.id)
}
