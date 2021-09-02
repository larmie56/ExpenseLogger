package com.example.expenselogger.cache.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.expenselogger.cache.ExpenseDatabase
import com.example.expenselogger.cache.entity.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
public class ExpenseRepositoryImplTest {

    private lateinit var expenseRepository: ExpenseRepository
    private lateinit var expenseDatabase: ExpenseDatabase

    @Before
    public fun setup() {
        expenseDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ExpenseDatabase::class.java
        ).allowMainThreadQueries().build()

        expenseRepository = ExpenseRepositoryImpl(
            expenseDatabase.expenseDao
        )
    }

    @Test
    public fun `verify that insertExpense inserts Expense into database`(): Unit =
        runBlockingTest {
            val expenseEntity = DummyData.expenseEntity
            expenseRepository.insertExpense(expenseEntity)
            val expectedExpenseEntity = expenseRepository.getExpense(0)
            assertThat(expectedExpenseEntity).isEqualTo(expenseEntity)
        }

    @Test
    public fun `verify that getExpenses gets list of expenses`(): Unit = runBlockingTest {
        val expense = DummyData.expenseEntity
        expenseRepository.insertExpense(expense)
        val expectedExpenses = expenseRepository.getExpenses().first()
        assertThat(expense).isEqualTo(expectedExpenses)
    }

    @Test
    public fun `verify that getExpense gets an expense`(): Unit = runBlockingTest {
        val expenseEntity = DummyData.expenseEntity
        expenseRepository.insertExpense(expenseEntity)
        val expectedExpenseEntity = expenseRepository.getExpense(0)
        assertThat(expectedExpenseEntity).isEqualTo(expenseEntity)
    }

    @After
    public fun `tearDown()`() {
        expenseDatabase.close()
    }
}
