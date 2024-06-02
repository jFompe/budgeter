package com.jfompe.budgeter.application.api.account.model

data class RequisitionDTO(
	val id: String,
//	val institutionId: String,
	val agreement: String,
	val accounts: List<String>,
	val link: String
)
