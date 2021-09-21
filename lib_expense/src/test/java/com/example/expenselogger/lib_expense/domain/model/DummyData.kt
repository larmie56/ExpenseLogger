package com.example.expenselogger.lib_expense.domain.model

import com.example.expenselogger.cache.entity.ExpenseEntity
import java.util.Date

internal object DummyData {

    val expense: Expense = Expense(
        id = 0,
        name = "Valentine outing",
        amount = 13_500.00,
        date = Date(1613311218000), // February 14th 2021
        info = "Valentine outing with bae"
    )

    val expenseEntity: ExpenseEntity = ExpenseEntity(
        name = "Valentine outing",
        amount = 13_500.00,
        date = Date(1613311218000).time, // February 14th 2021
        info = "Valentine outing with bae"
    )
}
