package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.executor.TestAsyncExecutor
import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

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

        assertThat(savedExpense?.amount).isEqualTo(13_500.00)
    }
}
