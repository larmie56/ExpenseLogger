package com.example.expenselogger.lib_expense.domain.fakes

import com.example.expenselogger.cache.entity.ExpenseEntity
import com.example.expenselogger.cache.repository.ExpenseRepository

public class FakeExpenseRepository : ExpenseRepository {

    private val database = LinkedHashMap<Long, ExpenseEntity>()

    override suspend fun insertExpense(expenseEntity: ExpenseEntity): Long {
        val expenseEntityCopy =
            expenseEntity.copy(id = expenseEntity.id.plus(1)) // simulate room id auto-generate
        database[expenseEntityCopy.id] = expenseEntityCopy
        return expenseEntityCopy.id
    }

    override suspend fun updateExpense(expenseEntity: ExpenseEntity) {
        val expenseEntityCopy =
            expenseEntity.copy(id = expenseEntity.id.plus(1))
        database.replace(expenseEntityCopy.id, expenseEntityCopy)
    }

    override suspend fun getExpense(id: Long): ExpenseEntity? {
        return database[id]
    }

    override suspend fun getExpenses(): List<ExpenseEntity> {
        return database.toList().map { it.second }
    }

    override suspend fun deleteExpense(id: Long) {
        database.remove(id)
    }
}
