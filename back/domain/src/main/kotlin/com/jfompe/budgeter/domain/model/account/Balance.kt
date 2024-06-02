package com.jfompe.budgeter.domain.model.account

data class Balance(
	val amount: Double,
	val currency: String,
	val date: String
)

typealias BalanceDomain = Balance
