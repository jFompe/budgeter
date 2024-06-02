package com.jfompe.budgeter.infrastructure.repository.institution.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Institution(
	val id: String,
	val name: String,
	val bic: String,
	@JsonProperty("transaction_total_days") val maxDays: Int,
	val countries: List<String>,
	val logo: String
)
