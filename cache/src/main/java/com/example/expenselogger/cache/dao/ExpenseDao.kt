package com.example.expenselogger.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expenselogger.cache.entity.ExpenseEntity

@Dao
internal interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: ExpenseEntity)

    @Update
    suspend fun updateExpense(expense: ExpenseEntity)

    @Query("SELECT * FROM expense WHERE id = :id")
    suspend fun getExpense(id: Long): ExpenseEntity

    @Query("SELECT * FROM expense ORDER BY date ASC")
    suspend fun getExpenses(): List<ExpenseEntity>

    @Query("DELETE FROM expense WHERE id = :id")
    suspend fun deleteExpense(id: Long)
}
