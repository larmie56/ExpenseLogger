package com.example.expenselogger.cache.entity

import java.util.Date

internal object DummyData {

    val EXPENSE_CACHE_MODEL: ExpenseCacheModel = ExpenseCacheModel(
        name = "Valentine outing",
        amount = 13_500.00,
        date = Date(1613311218000).time, // February 14th 2021
        info = "Valentine outing with bae"
    )
}
