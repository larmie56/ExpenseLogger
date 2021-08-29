package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

public class GetExpenseTest {

    private val expenseContract = mock(ExpenseContract::class.java)
    private val getExpense = GetExpense(expenseContract, TestAsyncExecutor())

    @Test
    public fun `verify that getExpense usecase gets an expense`(): Unit = runBlockingTest {
        `when`(expenseContract.getExpense(0)).thenReturn(DummyData.expense)
        val expectedExpense = getExpense.invoke(0)
        assertThat(expectedExpense?.id).isEqualTo(DummyData.expense.id)
    }
}
