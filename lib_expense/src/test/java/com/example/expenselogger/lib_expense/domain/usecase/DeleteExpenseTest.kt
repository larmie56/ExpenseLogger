package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

internal class DeleteExpenseTest {

    private lateinit var expenseContract: ExpenseContract
    private lateinit var deleteExpense: DeleteExpense

    @Before
    fun setup() {
        expenseContract = mock()
        deleteExpense = DeleteExpense(expenseContract, TestAsyncExecutor())
    }

    @Test
    fun `verify that deleteExpense usecase deletes an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        deleteExpense.invoke(expense)
        verify(expenseContract).deleteExpense(expense)
    }
}
