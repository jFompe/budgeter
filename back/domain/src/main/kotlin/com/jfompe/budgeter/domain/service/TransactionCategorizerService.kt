package com.jfompe.budgeter.domain.service

import com.jfompe.budgeter.domain.model.account.Transaction
import com.jfompe.budgeter.domain.model.category.CategoriesConfig

class TransactionCategorizerService(
	private val categories: CategoriesConfig
) {

	fun categorize(transaction: Transaction): Transaction =
		transaction.fillCategoryByConcept()

	private fun Transaction.fillCategoryByConcept(): Transaction =
		apply { category =
			if (amount < 0)
				getExpenseCategoryByConcept(concept)
			else
				getEarningCategoryByConcept(concept)
		}

	private fun getExpenseCategoryByConcept(concept: String) =
		getCategoryByConcept(concept, categories.expenses, "Otros Gastos")

	private fun getEarningCategoryByConcept(concept: String) =
		getCategoryByConcept(concept, categories.earnings, "Otros Ingresos")

	private fun getCategoryByConcept(concept: String, categories: Map<String, List<String>>, default: String) =
		categories.entries
			.find { entry ->
				entry.value
					?.takeIf { it.isNotEmpty() }
					?.any { concept.containsIgnoreCase(it) }
					?: concept.containsIgnoreCase(entry.key) }
			?.key
			?: default

	private fun String.containsIgnoreCase(other: String) =
		lowercase().contains(other.lowercase())

}