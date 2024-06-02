package com.jfompe.budgeter.infrastructure.repository.agreement.model

import com.fasterxml.jackson.annotation.JsonProperty

data class AgreementRequest(
	@JsonProperty("institution_id") val institutionId: String,
	@JsonProperty("max_historical_days") val maxDays: Int,
	@JsonProperty("access_valid_for_days") val accessValidForDays: Int,
	@JsonProperty("access_scope") val accessScope: List<String>
)
