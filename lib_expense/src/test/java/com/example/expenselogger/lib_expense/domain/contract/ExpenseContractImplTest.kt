package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.lib_expense.domain.fakes.FakeExpenseRepository
import com.example.expenselogger.lib_expense.domain.impl.ExpenseContractImpl
import com.example.expenselogger.lib_expense.domain.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

public class ExpenseContractImplTest {

    private lateinit var expenseContract: ExpenseContractImpl
    private lateinit var expenseRepository: FakeExpenseRepository
    private lateinit var expenseModelMapper: ExpenseModelMapper

    @Before
    public fun setup() {
        expenseRepository = FakeExpenseRepository()
        expenseModelMapper = ExpenseModelMapper()
        expenseContract = ExpenseContractImpl(
            expenseRepository,
            expenseModelMapper
        )
    }

    @Test
    public fun `verify that getExpenses returns list of expenses`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val id = expenseContract.insertExpense(expense)
        val actual = expenseContract.getExpenses()
        val expected = listOf(expense.copy(id))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    public fun `verify that getExpenses returns empty list when database is empty`(): Unit =
        runBlockingTest {
            val actual = expenseContract.getExpenses()
            assertTrue(actual.isEmpty())
        }

    @Test
    public fun `verify that getExpense gets an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val id = expenseContract.insertExpense(expense)
        val actual = expenseContract.getExpense(id)
        assertThat(actual).isEqualTo(expense.copy(id))
    }

    @Test
    public fun `verify that insertExpense inserts an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val id = expenseContract.insertExpense(expense)
        val actual = expenseContract.getExpense(id)
        assertThat(actual).isEqualTo(expense.copy(id))
    }

    @Test
    public fun `verify that updateExpense updates an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val id = expenseContract.insertExpense(expense)
        val newInfo = "Valentine outing with now ex bae"
        val updatedExpense = expense.copy(id, info = newInfo)
        expenseContract.updateExpense(updatedExpense)
        val actual = expenseContract.getExpense(updatedExpense.id)
        assertThat(actual).isEqualTo(updatedExpense)
    }

    @Test
    public fun `verify that delete expense deletes an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val id = expenseContract.insertExpense(expense)
        expenseContract.deleteExpense(expense.copy(id))
        val actual = expenseContract.getExpense(id)
        assertThat(actual).isNull()
    }
}
