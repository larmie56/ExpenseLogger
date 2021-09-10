package com.example.expenselogger.lib_expense.domain.model

import java.util.Date

public data class Expense(
    val id: Long,
    val name: String,
    val amount: Double,
    val date: Date,
    val info: String
) {
    public companion object ExpenseFactory {
        public fun createExpense(name: String, amount: Double, date: Date, info: String): Expense =
            Expense(0, name, amount, date, info)
    }
}
