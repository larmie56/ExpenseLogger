package com.example.expenselogger.cache.repository

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.expenselogger.cache.ExpenseDatabase
import com.example.expenselogger.cache.entity.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class ExpenseRepositoryTest {

    private lateinit var expenseRepository: ExpenseRepository
    private lateinit var expenseDatabase: ExpenseDatabase

    @Before
    fun setup() {
        expenseDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ExpenseDatabase::class.java
        ).allowMainThreadQueries().build()

        expenseRepository = ExpenseRepositoryImpl(
            expenseDatabase.expenseDao
        )
    }

    @After
    fun `tearDown()`() {
        expenseDatabase.close()
    }

    @Test
    fun `verify that insertExpense inserts Expense into database`(): Unit =
        runBlocking {
            val expenseEntity = DummyData.expenseEntity
            val id = expenseRepository.insertExpense(expenseEntity)
            val actual = expenseRepository.getExpense(id)
            assertThat(actual).isEqualTo(expenseEntity)
        }

    @Test
    fun `verify that getExpenses gets list of expenses`(): Unit = runBlocking {
        val expense = DummyData.expenseEntity
        expenseRepository.insertExpense(expense)
        val actual = expenseRepository.getExpenses()
        assertThat(actual).isEqualTo(listOf(expense))
    }

    @Test
    fun `verify that getExpense gets an expense`(): Unit = runBlocking {
        val expenseEntity = DummyData.expenseEntity
        val id = expenseRepository.insertExpense(expenseEntity)
        val actual = expenseRepository.getExpense(id)
        assertThat(actual).isEqualTo(expenseEntity)
    }

    @Test
    fun `verify that updateExpense updates an expense`(): Unit = runBlocking {
        val expenseEntity = DummyData.expenseEntity
        val id = expenseRepository.insertExpense(expenseEntity)
        val newExpenseEntity = expenseRepository.getExpense(id)
        val newInfo = "Valentine outing with now ex bae"
        val newExpenseEntityCopy = newExpenseEntity?.copy(info = newInfo)
        newExpenseEntityCopy?.let {
            it.id = id
            expenseRepository.updateExpense(it)
        }
        val actual = expenseRepository.getExpense(id)
        assertThat(actual?.info).isEqualTo(newInfo)
    }

    @Test
    fun `verify that deleteExpense deletes an expense`(): Unit = runBlocking {
        val expenseEntity = DummyData.expenseEntity
        val id = expenseRepository.insertExpense(expenseEntity)
        expenseRepository.deleteExpense(id)
        val actual = expenseRepository.getExpense(id)
        assertThat(actual).isNull()
    }
}
