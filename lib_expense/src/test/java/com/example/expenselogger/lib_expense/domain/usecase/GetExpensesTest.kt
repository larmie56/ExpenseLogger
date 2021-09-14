package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

internal class GetExpensesTest {

    @Test
    fun `verify that getExpenses usecase gets a list of expenses`(): Unit = runBlockingTest {
        val expenses = listOf(DummyData.expense)
        val expenseContract = mock<ExpenseContract>().apply {
            whenever(getExpenses()).thenReturn(expenses)
        }
        val getExpenses = GetExpenses(expenseContract, TestAsyncExecutor())
        val expectedExpenses = getExpenses.invoke()
        assertThat(expectedExpenses).isEqualTo(expenses)
    }
}
