package com.jfompe.budgeter.infrastructure.repository.account.model

data class Transactions(
	val booked: List<Transaction> = emptyList(),
	val pending: List<Transaction> = emptyList()
)
