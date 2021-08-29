package com.example.expenselogger.cache.di

import android.content.Context
import com.example.expenselogger.cache.ExpenseDatabase
import com.example.expenselogger.cache.dao.ExpenseDao
import com.example.expenselogger.cache.repository.ExpenseRepository
import com.example.expenselogger.cache.repository.ExpenseRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
internal object CacheModule {

    @[Provides Singleton]
    public fun providesExpenseDatabase(@ApplicationContext context: Context): ExpenseDatabase {
        return ExpenseDatabase.build(context)
    }

    @[Provides Singleton]
    public fun providesExpenseDao(expenseDatabase: ExpenseDatabase): ExpenseDao {
        return expenseDatabase.expenseDao
    }
}

@[Module InstallIn(SingletonComponent::class)]
internal interface CacheModuleBinding {
    @get:Binds
    public val ExpenseRepositoryImpl.expenseRepository: ExpenseRepository
}
