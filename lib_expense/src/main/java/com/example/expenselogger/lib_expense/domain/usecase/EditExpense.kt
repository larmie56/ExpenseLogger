package com.example.expenselogger.lib_expense.domain.usecase

import com.example.expenselogger.lib_expense.domain.contract.ExpenseContract
import com.example.expenselogger.lib_expense.domain.model.Expense

class EditExpense(
    private val expenseContract: ExpenseContract
) {

    /**
     * A higher order function function for editing expense
     *
     * @param id - id of the expense to edit
     * @param performEdit - function to perform the edit. It takes the expense to edit as a
     * parameter, and returns the expense when the edit is done
     */
    suspend fun editExpense(id: Long, performEdit: (Expense) -> Expense) {
        val expense = expenseContract.getExpense(id)

        val editedExpense = performEdit.invoke(requireNotNull(expense))

        expenseContract.saveExpense(editedExpense)
    }
}
