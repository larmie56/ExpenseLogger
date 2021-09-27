package com.example.expenselogger.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.entity.ExpenseCacheModel

@Database(entities = [ExpenseCacheModel::class], version = 1, exportSchema = false)
internal abstract class ExpenseDatabase : RoomDatabase() {

    abstract val expenseDao: ExpenseDao

    companion object {
        private const val DATABASE_NAME: String = "expense_db"
        fun build(context: Context): ExpenseDatabase = Room.databaseBuilder(
            context.applicationContext,
            ExpenseDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}
