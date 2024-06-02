package com.jfompe.budgeter.infrastructure.repository.requisition.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Requisition(
	val id: String,
	val redirect: String,
	val status: String,
	val agreement: String,
	val accounts: List<String>,
	val reference: String,
	@JsonProperty("user_language") val lang: String,
	val link: String
)
