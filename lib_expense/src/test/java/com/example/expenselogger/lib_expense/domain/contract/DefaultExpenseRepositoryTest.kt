package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.cache.repository.ExpenseCache
import com.example.expenselogger.lib_expense.data.impl.DefaultExpenseRepository
import com.example.expenselogger.lib_expense.data.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class DefaultExpenseRepositoryTest {

    @Test
    fun `verify that getExpenses returns list of expenses`() = runBlockingTest {
        val expenseCacheModel = DummyData.expenseCacheModel
        val expense = DummyData.expense

        val expenseModelMapper = mock<ExpenseModelMapper> {
            on {
                mapToExpenseList(listOf(expenseCacheModel))
            } doReturn listOf(expense)
        }
        val expenseCache = mock<ExpenseCache>().apply {
            whenever(getExpenses()).thenReturn(listOf(expenseCacheModel))
        }
        val expenseRepository = DefaultExpenseRepository(
            expenseCache = expenseCache,
            expenseModelMapper = expenseModelMapper
        )

        val expenses = expenseRepository.getExpenses()
        assertThat(expenses).isEqualTo(listOf(expense))
    }

    @Test
    fun `when getExpense is called with a valid id, then the correct expense is returned`() {
        runBlockingTest {
            val expense = DummyData.expense
            val expenseCacheModel = DummyData.expenseCacheModel

            val expenseModelMapper = mock<ExpenseModelMapper> {
                on {
                    mapToExpense(expenseCacheModel)
                } doReturn expense
            }
            val expenseCache = mock<ExpenseCache>().apply {
                whenever(getExpense(0)).thenReturn(expenseCacheModel)
            }
            val expenseRepository = DefaultExpenseRepository(
                expenseCache = expenseCache,
                expenseModelMapper = expenseModelMapper
            )

            val actual = expenseRepository.getExpense(0)
            assertThat(actual).isEqualTo(expense)
        }
    }

    @Test
    fun `when getExpense is called with an invalid id, then no expense is returned`() =
        runBlockingTest {
            val expenseCacheModel = DummyData.expenseCacheModel

            val expenseCache = mock<ExpenseCache>().apply {
                whenever(getExpense(0)).thenReturn(expenseCacheModel)
            }
            val expenseRepository = DefaultExpenseRepository(
                expenseCache = expenseCache,
                expenseModelMapper = mock()
            )

            val actual = expenseRepository.getExpense(1)
            assertThat(actual).isNull()
        }

    @Test
    fun `verify that insertExpense inserts an expense`() = runBlockingTest {
        val expense = DummyData.expense
        val expenseCacheModel = DummyData.expenseCacheModel

        val expenseModelMapper = mock<ExpenseModelMapper> {
            on {
                mapToCacheModel(expense)
            } doReturn expenseCacheModel
        }
        val expenseCache = mock<ExpenseCache>()
        val expenseRepository = DefaultExpenseRepository(
            expenseCache = expenseCache,
            expenseModelMapper = expenseModelMapper
        )

        expenseRepository.insertExpense(expense)
        verify(expenseCache).insertExpense(expenseCacheModel)
    }

    @Test
    fun `verify that updateExpense updates an expense`() = runBlockingTest {
        val expense = DummyData.expense
        val expenseCacheModel = DummyData.expenseCacheModel

        val expenseModelMapper = mock<ExpenseModelMapper> {
            on {
                mapToCacheModel(expense)
            } doReturn expenseCacheModel
        }
        val expenseCache = mock<ExpenseCache>()
        val expenseRepository = DefaultExpenseRepository(
            expenseCache = expenseCache,
            expenseModelMapper = expenseModelMapper
        )

        expenseRepository.updateExpense(expense)
        verify(expenseCache).updateExpense(expenseCacheModel)
    }

    @Test
    fun `verify that delete expense deletes an expense`() = runBlockingTest {
        val expenseCache = mock<ExpenseCache>()
        val expenseRepository = DefaultExpenseRepository(
            expenseCache = expenseCache,
            expenseModelMapper = mock()
        )

        expenseRepository.deleteExpense(0)
        verify(expenseCache).deleteExpense(0)
    }
}
