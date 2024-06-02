package com.jfompe.budgeter.infrastructure.repository.agreement.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AgreementResponse(
	val id: String,
	val created: LocalDateTime,
	@JsonProperty("institution_id") val institutionId: String,
	@JsonProperty("max_historical_days") val maxHistoricalDays: Int,
	@JsonProperty("access_valid_for_days") val accessValidForDays: Int,
	@JsonProperty("access_scope") val accessScope: List<String>,
	val accepted: LocalDateTime?
)
