package com.jfompe.budgeter.infrastructure.repository.requisition.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RequisitionRequest(
	val redirect: String,
	@JsonProperty("institution_id") val institutionId: String,
	val reference: String,
	val agreement: String,
	@JsonProperty("user_language") val userLanguage: String,
	@JsonProperty("account_selection") val accountSelection: Boolean,
	@JsonProperty("redirect_immediate") val redirectImmediate: Boolean
)
