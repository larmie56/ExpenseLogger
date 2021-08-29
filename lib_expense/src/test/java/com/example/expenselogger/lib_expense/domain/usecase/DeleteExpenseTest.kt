package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

public class DeleteExpenseTest {

    private val expenseContract: ExpenseContract = mock(ExpenseContract::class.java)
    private val deleteExpense = DeleteExpense(expenseContract, TestAsyncExecutor())

    @Test
    public fun `verify that deleteExpense usecase deletes an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        deleteExpense.invoke(expense)
        verify(expenseContract).deleteExpense(expense)
    }
}
