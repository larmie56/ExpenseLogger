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

public class GetExpenseTest {

    private val expenseContract = FakeExpenseContract()
    private val getExpense = GetExpense(
        expenseContract,
        TestAsyncExecutor()
    )

    @Test
    public fun `verify that getExpense usecase returns an expense`(): Unit =
        runBlockingTest {
            val expense = DummyData.expense
            expenseContract.saveExpense(expense)
            val expectedExpense = getExpense.invoke(expense.id)
            assertThat(expectedExpense).isEqualTo(expense)
        }

    @Test
    public fun `verify that getExpense usecase calls expenseContract`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val mockExpenseContract = mock(ExpenseContract::class.java)
        val mockGetExpense = GetExpense(mockExpenseContract, TestAsyncExecutor())
        mockGetExpense.invoke(expense.id)
        verify(mockExpenseContract).getExpense(expense.id)
    }
}
