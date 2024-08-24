package com.jfompe.budgeter.domain.model.account

data class Transaction(
	val date: String,
	val amount: Double,
	val currency: String,
	val concept: String,
	var balance: Double = 0.0,
	var category: String? = null
)

typealias TransactionDomain = Transaction
