package com.jfompe.budgeter.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "budgeter")
data class ExpenseCategoriesProperties (
	val expenseCategories: Map<String, List<String>>
)