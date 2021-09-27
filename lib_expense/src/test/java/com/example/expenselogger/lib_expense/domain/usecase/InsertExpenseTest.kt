package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

internal class InsertExpenseTest {

    private lateinit var expenseRepository: ExpenseRepository
    private lateinit var insertExpense: InsertExpense

    @Before
    fun setup() {
        expenseRepository = mock()
        insertExpense = InsertExpense(expenseRepository, TestAsyncExecutor())
    }

    @Test
    fun `verify that insertExpense usecase inserts an expense`() = runBlockingTest {
        val expense = DummyData.expense
        insertExpense.invoke(expense)
        verify(expenseRepository).insertExpense(expense)
    }
}
