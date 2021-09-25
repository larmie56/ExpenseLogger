package com.example.expenselogger.lib_expense.data.mapper

import com.example.expenselogger.cache.entity.ExpenseCacheModel
import com.example.expenselogger.lib_expense.domain.model.Expense
import java.util.Date
import javax.inject.Inject

internal class ExpenseModelMapper @Inject constructor() {

    fun mapToExpense(
        model: ExpenseCacheModel
    ): Expense = Expense(
        id = model.id,
        name = model.name,
        amount = model.amount,
        date = Date(model.date),
        info = model.info
    )

    fun mapToCacheModel(
        expense: Expense
    ): ExpenseCacheModel = ExpenseCacheModel(
        id = expense.id,
        name = expense.name,
        amount = expense.amount,
        date = expense.date.time,
        info = expense.info
    )

    fun mapToExpenseList(
        model: List<ExpenseCacheModel>
    ): List<Expense> =
        model.mapTo(mutableListOf(), ::mapToExpense)

    fun mapToModelList(
        expense: List<Expense>
    ): List<ExpenseCacheModel> =
        expense.mapTo(mutableListOf(), ::mapToCacheModel)
}
