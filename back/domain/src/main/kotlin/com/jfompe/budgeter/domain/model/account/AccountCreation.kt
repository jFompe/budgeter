package com.jfompe.budgeter.domain.model.account

data class AccountCreation(
	val institutionId: String,
	val redirectUri: String,
	val lang: String
)
