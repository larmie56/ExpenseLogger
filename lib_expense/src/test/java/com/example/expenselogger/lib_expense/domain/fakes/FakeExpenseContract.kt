package com.example.expenselogger.lib_expense.domain.fakes

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

public class FakeExpenseContract : ExpenseContract {

    private val database = mutableListOf<Expense>()

    override suspend fun saveExpense(expense: Expense) {
        if (expense.id in Int.MIN_VALUE..Int.MAX_VALUE) {
            database.add(index = expense.id.toInt(), expense)
        } else {
            throw ArrayIndexOutOfBoundsException("id must be within -2147483648 to 2147483647")
        }
    }

    override suspend fun getExpense(id: Long): Expense? {
        return database[id.toInt()]
    }

    override suspend fun getExpenses(): List<Expense> {
        return database.toList()
    }

    override suspend fun deleteExpense(expense: Expense) {
        database.remove(expense)
    }
}
