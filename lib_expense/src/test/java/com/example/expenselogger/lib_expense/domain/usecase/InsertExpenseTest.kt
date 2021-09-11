package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

public class InsertExpenseTest {

    private lateinit var expenseContract: ExpenseContract
    private lateinit var insertExpense: InsertExpense

    @Before
    public fun setup() {
        expenseContract = mock()
        insertExpense = InsertExpense(expenseContract, TestAsyncExecutor())
    }

    @Test
    public fun `verify that insertExpense usecase inserts an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        insertExpense.invoke(expense)
        verify(expenseContract).insertExpense(expense)
    }
}
