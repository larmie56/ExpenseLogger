package com.example.expenselogger.lib_expense.domain.model

import java.util.Date

public data class Expense(
    val id: Long,
    val name: String,
    val amount: Double,
    val date: Date,
    val info: String
)
