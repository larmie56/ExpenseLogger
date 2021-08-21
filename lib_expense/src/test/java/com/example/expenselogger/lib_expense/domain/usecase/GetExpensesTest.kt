package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.TestAsyncExecutor
import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

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
}
