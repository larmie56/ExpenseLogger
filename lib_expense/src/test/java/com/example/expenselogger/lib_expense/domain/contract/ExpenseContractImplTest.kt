package com.example.expenselogger.lib_expense.domain.contract

import com.example.expenselogger.cache.repository.ExpenseCacheRepository
import com.example.expenselogger.lib_expense.data.impl.ExpenseContractImpl
import com.example.expenselogger.lib_expense.data.mapper.ExpenseModelMapper
import com.example.expenselogger.lib_expense.domain.model.DummyData
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

internal class ExpenseContractImplTest {

    private lateinit var expenseContract: ExpenseContractImpl
    private lateinit var expenseRepository: ExpenseCacheRepository
    private lateinit var expenseModelMapper: ExpenseModelMapper

    @Before
    fun setup() {
        expenseRepository = mock()
        expenseModelMapper = ExpenseModelMapper()
        expenseContract = ExpenseContractImpl(
            expenseRepository,
            expenseModelMapper
        )
    }

    @Test
    fun `verify that getExpenses returns list of expenses`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val expenseEntities = expenseModelMapper.mapFromModelList(listOf(expense))
        expenseRepository.apply {
            whenever(getExpenses()).thenReturn(expenseEntities)
        }
        expenseContract.getExpenses()
        verify(expenseRepository).getExpenses()
    }

    @Test
    fun `verify that getExpense gets an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        expenseContract.getExpense(expense.id)
        verify(expenseRepository).getExpense(expense.id)
    }

    @Test
    fun `verify that insertExpense inserts an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val expenseEntity = expenseModelMapper.mapFromModel(expense)
        expenseContract.insertExpense(expense)
        verify(expenseRepository).insertExpense(expenseEntity)
    }

    @Test
    fun `verify that updateExpense updates an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        val expenseEntity = expenseModelMapper.mapFromModel(expense)
        expenseContract.updateExpense(expense)
        verify(expenseRepository).updateExpense(expenseEntity)
    }

    @Test
    fun `verify that delete expense deletes an expense`(): Unit = runBlockingTest {
        val expense = DummyData.expense
        expenseContract.deleteExpense(expense)
        verify(expenseRepository).deleteExpense(expense.id)
    }
}
