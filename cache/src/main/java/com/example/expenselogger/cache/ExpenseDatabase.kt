package com.example.expenselogger.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.entity.ExpenseEntity

@Database(entities = [ExpenseEntity::class], version = 1, exportSchema = false)
public abstract class ExpenseDatabase : RoomDatabase() {

    public abstract val expenseDao: ExpenseDao

    public companion object {
        private const val DATABASE_NAME: String = "expense_db"
        private lateinit var INSTANCE: ExpenseDatabase
        public fun build(context: Context): ExpenseDatabase {
            synchronized(ExpenseDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ExpenseDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}
