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
            assertThat(actual).isEqualTo(expenseEntity.copy(id = id))
        }

    @Test
    fun `verify that updateExpense updates an Expense in the database`(): Unit =
        runBlocking {
            val expenseEntity = DummyData.expenseEntity
            val id = expenseRepository.insertExpense(expenseEntity)
            val newInfo = "Valentine outing with now ex bae"
            val expenseEntityUpdate = expenseEntity.copy(id = id, info = newInfo)
            expenseRepository.updateExpense(expenseEntityUpdate)
            val actual = expenseRepository.getExpense(id)
            assertThat(actual).isEqualTo(expenseEntityUpdate)
        }

    @Test
    fun `verify that getExpenses gets list of expenses`(): Unit = runBlocking {
        val expense = DummyData.expenseEntity
        val id = expenseRepository.insertExpense(expense)
        val id2 = expenseRepository.insertExpense(expense)
        val actual = expenseRepository.getExpenses()
        val expected = listOf(
            expense.copy(id = id),
            expense.copy(id = id2)
        )
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `verify that getExpense gets an expense`(): Unit = runBlocking {
        val expenseEntity = DummyData.expenseEntity
        val id = expenseRepository.insertExpense(expenseEntity)
        val actual = expenseRepository.getExpense(id)
        assertThat(actual).isEqualTo(expenseEntity.copy(id = id))
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
