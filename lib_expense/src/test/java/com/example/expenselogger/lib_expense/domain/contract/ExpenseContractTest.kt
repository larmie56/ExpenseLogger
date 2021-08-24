package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseContract
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.example.expenselogger.lib_expense.domain.model.Expense
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Date

public class ExpenseContractTest {

    private val expenseContract = FakeExpenseContract()

    @Test
    public fun `verify that getExpenses returns list of expenses`(): Unit = runBlockingTest {
        val expense = DummyData.expense

        expenseContract.saveExpense(expense)
        val expectedExpenses = expenseContract.getExpenses()

        assertThat(expectedExpenses.size).isEqualTo(1)
        assertThat(expectedExpenses[0].id).isEqualTo(0)
        assertThat(expectedExpenses[0].amount).isEqualTo(13_500.00)
    }

    @Test
    public fun `verify that getExpenses returns empty list when database is empty`(): Unit =
        runBlockingTest {
            val expectedExpenses = expenseContract.getExpenses()

            assertTrue(expectedExpenses.isEmpty())
        }

    @Test
    public fun `verify that getExpense returns an expense if it exists`(): Unit = runBlockingTest {
        val expense = DummyData.expense

        expenseContract.saveExpense(expense)
        val expectedExpense = expenseContract.getExpense(0)

        Assert.assertNotNull(expectedExpense)
        assertThat(expectedExpense?.id).isEqualTo(0)
        assertThat(expectedExpense?.amount).isEqualTo(13_500.00)
    }

    @Test
    public fun `verify that saveExpense saves an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense

        expenseContract.saveExpense(expense)
        val savedExpense = expenseContract.getExpense(expense.id)

        assertThat(expenseContract.getExpenses().size).isEqualTo(1)
        assertThat(savedExpense?.id).isEqualTo(0)
        assertThat(savedExpense?.amount).isEqualTo(13_500.00)
    }

    @Test(expected = ArrayIndexOutOfBoundsException::class)
    public fun `verify that saveExpense throws ArrayIndexOutOfBoundsException when expense id is out of intRange`(): Unit =
        runBlockingTest {
            val expense = Expense(
                id = 96133223321121364,
                name = "Valentine outing",
                amount = 13_500.00,
                date = Date(1613311218000), // February 14th 2021
                info = "Valentine outing with bae"
            )

            expenseContract.saveExpense(expense)
        }

    @Test
    public fun `verify that delete expense deletes an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense

        expenseContract.saveExpense(expense)
        assertThat(expenseContract.getExpenses().size).isEqualTo(1)
        expenseContract.deleteExpense(expense)
        assertThat(expenseContract.getExpenses().size).isEqualTo(0)
    }
}
