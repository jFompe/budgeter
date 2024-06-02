package com.jfompe.budgeter.domain.model.institution

data class Institution(
	val id: String,
	val name: String,
	val logo: String,
	val countries: List<String>,
	val maxDays: Int
)

typealias InstitutionDomain = Institution
