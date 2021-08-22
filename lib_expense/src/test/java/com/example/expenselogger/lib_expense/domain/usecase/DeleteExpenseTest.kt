package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

public class DeleteExpenseTest {

    private val expenseContract = FakeExpenseContract()
    private val deleteExpense = DeleteExpense(
        expenseContract,
        TestAsyncExecutor()
    )

    @Test
    public fun `verify that deleteExpense usecase deletes an expense if it exists`(): Unit =
        runBlockingTest {
            val expense = DummyData.expense
            expenseContract.saveExpense(expense)
            deleteExpense.invoke(expense)
            assertThat(expenseContract.getExpenses().size).isEqualTo(0)
        }
}
