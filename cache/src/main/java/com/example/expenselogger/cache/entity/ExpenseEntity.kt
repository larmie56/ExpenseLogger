package com.example.expenselogger.cache.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
public data class ExpenseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "amount")
    val amount: Double,
    @ColumnInfo(name = "date")
    val date: Long,
    @ColumnInfo(name = "info")
    val info: String
)
