package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseRepository
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class UpdateExpenseTest {

    private lateinit var expenseRepository: ExpenseRepository
    private lateinit var updateExpense: UpdateExpense

    @Before
    fun setup() {
        expenseRepository = mock()
        updateExpense = UpdateExpense(
            expenseRepository,
            TestAsyncExecutor()
        )
    }

    @Test
    fun `verify that updateExpense usecase updates an expense`() = runBlockingTest {
        val expense = DummyData.expense
        updateExpense.invoke(expense)
        verify(expenseRepository).updateExpense(expense)
    }
}
