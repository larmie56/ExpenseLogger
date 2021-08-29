package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

public class GetExpensesTest {

    private val expenseContract = mock(ExpenseContract::class.java)
    private val getExpenses = GetExpenses(expenseContract, TestAsyncExecutor())

    @Test
    public fun `verify that getExpenses usecase gets a list of expenses`(): Unit = runBlockingTest {
        `when`(expenseContract.getExpenses()).thenReturn(listOf(DummyData.expense))
        val expectedExpenses = getExpenses.invoke()
        assertThat(expectedExpenses.size).isEqualTo(1)
    }
}
