package com.jfompe.budgeter.infrastructure.repository.token.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NewTokenResponse(
	val access: String,
	@JsonProperty("access_expires") val accessExpiresInSeconds: Int,
	val refresh: String,
	@JsonProperty("refresh_expires") val refreshExpiresInSeconds: Int
)
