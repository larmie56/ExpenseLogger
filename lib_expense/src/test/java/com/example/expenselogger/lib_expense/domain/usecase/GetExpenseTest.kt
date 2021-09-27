package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class GetExpenseTest {

    @Test
    fun `verify that getExpense usecase gets an expense`() = runBlockingTest {
        val expense = DummyData.expense
        val expenseContract = mock<ExpenseRepository>().apply {
            whenever(getExpense(0)).thenReturn(expense)
        }
        val getExpense = GetExpense(expenseContract, TestAsyncExecutor())
        val expectedExpense = getExpense.invoke(0)
        assertThat(expectedExpense).isEqualTo(expense)
    }
}
