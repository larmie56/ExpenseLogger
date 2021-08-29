package com.example.expenselogger.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expenselogger.cache.entity.ExpenseEntity

@Dao
internal interface ExpenseDao {
    @Insert
    public fun insertExpense(expense: ExpenseEntity)

    @Update
    public fun updateExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expense WHERE id = :id")
    public fun getExpense(id: Long): ExpenseEntity

    @Query("SELECT * FROM expense ORDER BY date ASC")
    public fun getExpenses(): List<ExpenseEntity>

    @Query("DELETE FROM expense WHERE id = :id")
    public fun deleteExpense(id: Long)
}
