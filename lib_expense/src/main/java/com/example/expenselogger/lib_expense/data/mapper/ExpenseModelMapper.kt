package com.example.expenselogger.lib_expense.data.mapper

import com.example.expenselogger.cache.entity.ExpenseEntity
import com.example.expenselogger.lib_expense.domain.model.Expense
import java.util.Date
import javax.inject.Inject

internal class ExpenseModelMapper @Inject constructor() {

    fun mapToModel(expenseEntity: ExpenseEntity): Expense {
        return Expense(
            id = expenseEntity.id,
            name = expenseEntity.name,
            amount = expenseEntity.amount,
            date = Date(expenseEntity.date),
            info = expenseEntity.info
        )
    }

    fun mapFromModel(expenseModel: Expense): ExpenseEntity {
        return ExpenseEntity(
            id = expenseModel.id,
            name = expenseModel.name,
            amount = expenseModel.amount,
            date = expenseModel.date.time,
            info = expenseModel.info
        )
    }

    fun mapToModelList(expenseEntities: List<ExpenseEntity>): List<Expense> {
        return expenseEntities.mapTo(mutableListOf(), ::mapToModel)
    }

    fun mapFromModelList(expenseModels: List<Expense>): List<ExpenseEntity> {
        return expenseModels.mapTo(mutableListOf(), ::mapFromModel)
    }
}
