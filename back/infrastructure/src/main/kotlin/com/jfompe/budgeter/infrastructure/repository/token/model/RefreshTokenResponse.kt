package com.jfompe.budgeter.infrastructure.repository.token.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RefreshTokenResponse(
	val access: String,
	@JsonProperty("access_expires") val accessExpiresInSeconds: Int
)
