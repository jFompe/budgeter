package com.jfompe.budgeter.application.api.account.model

data class AccountCreationDTO(
	val institutionId: String,
	val maxTransactionDays: Int,
	val redirectUri: String,
	val lang: String
)
