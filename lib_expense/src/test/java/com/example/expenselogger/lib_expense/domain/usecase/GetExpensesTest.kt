package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

public class GetExpensesTest {

    private val expenseContract = FakeExpenseContract()
    private val getExpenses = GetExpenses(
        expenseContract,
        TestAsyncExecutor()
    )

    @Test
    public fun `verify that expenses returns a list of expenses`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        expenseContract.saveExpense(expense)
        val expectedExpenses = getExpenses.invoke()
        assertThat(expectedExpenses.size).isEqualTo(1)
    }

    @Test
    public fun `verify that getExpenses usecase calls expenseContract`(): Unit = runBlockingTest {
        val mockExpenseContract = mock(ExpenseContract::class.java)
        val mockGetExpenses = GetExpenses(mockExpenseContract, TestAsyncExecutor())
        mockGetExpenses.invoke()
        verify(mockExpenseContract).getExpenses()
    }
}
