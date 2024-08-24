package com.jfompe.budgeter.domain.model.category

data class CategoriesConfig(
	val expenses: Map<String, List<String>>,
	val earnings: Map<String, List<String>>
)
