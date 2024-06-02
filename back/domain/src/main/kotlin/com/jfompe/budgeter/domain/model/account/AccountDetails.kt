package com.jfompe.budgeter.domain.model.account

data class AccountDetails(
	val iban: String,
	val currency: String,
	val ownerName: String,
	val displayName: String,
	val bic: String
)

typealias AccountDetailsDomain = AccountDetails