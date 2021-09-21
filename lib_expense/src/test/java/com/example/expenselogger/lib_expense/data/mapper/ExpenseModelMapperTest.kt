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
    fun `verify mapToModel maps to model`() {
        val entity = DummyData.expenseEntity
        val model = mapper.mapToModel(entity)
        assertThat(entity.name).isEqualTo(model.name)
        assertThat(entity.amount).isEqualTo(model.amount)
        assertThat(entity.date).isEqualTo(model.date.time)
        assertThat(entity.info).isEqualTo(model.info)
    }

    @Test
    fun `verify mapFromModel maps to entity`() {
        val model = DummyData.expense
        val entity = mapper.mapFromModel(model)
        assertThat(model.name).isEqualTo(entity.name)
        assertThat(model.amount).isEqualTo(entity.amount)
        assertThat(model.date).isEqualTo(Date(entity.date))
        assertThat(model.info).isEqualTo(entity.info)
    }

    @Test
    fun `verify mapToModelList maps to model list`() {
        val entities = listOf(DummyData.expenseEntity)
        val models = mapper.mapToModelList(entities)
        val expected = entities[0]
        val actual = models[0]
        assertThat(expected.name).isEqualTo(actual.name)
        assertThat(expected.amount).isEqualTo(actual.amount)
        assertThat(expected.date).isEqualTo(actual.date.time)
        assertThat(expected.info).isEqualTo(actual.info)
    }

    @Test
    fun `verify mapFromModelList maps to entity list`() {
        val models = listOf(DummyData.expense)
        val entities = mapper.mapFromModelList(models)
        val expected = models[0]
        val actual = entities[0]
        assertThat(expected.name).isEqualTo(actual.name)
        assertThat(expected.amount).isEqualTo(actual.amount)
        assertThat(expected.date).isEqualTo(Date(actual.date))
        assertThat(expected.info).isEqualTo(actual.info)
    }
}
