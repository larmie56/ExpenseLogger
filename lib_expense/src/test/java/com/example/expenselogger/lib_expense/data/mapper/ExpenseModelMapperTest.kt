package com.example.expenselogger.lib_expense.data.mapper

import com.example.expenselogger.lib_expense.domain.model.DummyData
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import java.util.Date

internal class ExpenseModelMapperTest {

    private lateinit var mapper: ExpenseModelMapper

    @Before
    fun setup() {
        mapper = ExpenseModelMapper()
    }

    @Test
    fun `when mapping from cache model, then the correct Expense is returned`() {
        val entity = DummyData.expenseCacheModel
        val model = mapper.mapToExpense(entity)
        assertThat(entity.name).isEqualTo(model.name)
        assertThat(entity.amount).isEqualTo(model.amount)
        assertThat(entity.date).isEqualTo(model.date.time)
        assertThat(entity.info).isEqualTo(model.info)
    }

    @Test
    fun `when mapping from Expense, then the correct cache model is returned`() {
        val model = DummyData.expense
        val entity = mapper.mapToCacheModel(model)
        assertThat(model.name).isEqualTo(entity.name)
        assertThat(model.amount).isEqualTo(entity.amount)
        assertThat(model.date).isEqualTo(Date(entity.date))
        assertThat(model.info).isEqualTo(entity.info)
    }

    @Test
    fun `when mapping list of cache model, then the correct expense list is returned`() {
        val cacheModelList = listOf(DummyData.expenseCacheModel)
        val expenses = mapper.mapToExpenseList(cacheModelList)

        val expected = cacheModelList[0]
        val actual = expenses[0]

        assertThat(expected.name).isEqualTo(actual.name)
        assertThat(expected.amount).isEqualTo(actual.amount)
        assertThat(expected.date).isEqualTo(actual.date.time)
        assertThat(expected.info).isEqualTo(actual.info)
    }

    @Test
    fun `when mapping list of expenses, then the correct cache model list is returned`() {
        val expenses = listOf(DummyData.expense)
        val cacheModelList = mapper.mapToModelList(expenses)

        val expected = expenses[0]
        val actual = cacheModelList[0]

        assertThat(expected.name).isEqualTo(actual.name)
        assertThat(expected.amount).isEqualTo(actual.amount)
        assertThat(expected.date).isEqualTo(Date(actual.date))
        assertThat(expected.info).isEqualTo(actual.info)
    }
}
