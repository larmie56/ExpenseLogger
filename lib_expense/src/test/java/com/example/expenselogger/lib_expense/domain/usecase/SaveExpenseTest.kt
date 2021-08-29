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

public class SaveExpenseTest {

    private val expenseContract = FakeExpenseContract()
    private val saveExpense = SaveExpense(
        expenseContract,
        TestAsyncExecutor()
    )

    @Test
    public fun `verify that saveExpense usecase saves an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        saveExpense.invoke(expense)
        val savedExpense = expenseContract.getExpense(expense.id)
        assertThat(savedExpense).isEqualTo(expense)
    }

    @Test
    public fun `verify that saveExpense usecase calls expenseContract`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val mockExpenseContract = mock(ExpenseContract::class.java)
        val mockSaveExpense = SaveExpense(mockExpenseContract, TestAsyncExecutor())
        mockSaveExpense.invoke(expense)
        verify(mockExpenseContract).saveExpense(expense)
    }
}
