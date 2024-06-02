package com.jfompe.budgeter.application.api.institution.model

data class InstitutionDTO(
	val id: String,
	val name: String,
	val logo: String,
	val countries: List<String>,
	val maxDays: Int
)
