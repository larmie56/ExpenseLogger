package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger_test_utils.TestAsyncExecutor
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

public class SaveExpenseTest {

    private lateinit var expenseContract: ExpenseContract
    private lateinit var saveExpense: SaveExpense

    @Before
    public fun setup() {
        expenseContract = mock()
        saveExpense = SaveExpense(expenseContract, TestAsyncExecutor())
    }

    @Test
    public fun `verify that saveExpense usecase saves an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        saveExpense.invoke(expense)
        verify(expenseContract).saveExpense(expense)
    }
}
