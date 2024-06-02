package com.jfompe.budgeter.infrastructure.repository.account.model

data class AccountDetails(
	val resourceId: String,
	val iban: String,
	val currency: String,
	val ownerName: String,
	val displayName: String,
	val bic: String
)
