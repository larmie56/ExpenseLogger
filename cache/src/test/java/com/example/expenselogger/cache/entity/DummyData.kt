package com.example.expenselogger.cache.entity

import java.util.Date

public object DummyData {

    public val expenseEntity: ExpenseEntity = ExpenseEntity(
        id = 0,
        name = "Valentine outing",
        amount = 13_500.00,
        date = Date(1613311218000).time, // February 14th 2021
        info = "Valentine outing with bae"
    )
}
