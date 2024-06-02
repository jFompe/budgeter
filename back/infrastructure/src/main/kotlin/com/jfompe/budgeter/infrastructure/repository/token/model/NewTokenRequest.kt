package com.jfompe.budgeter.infrastructure.repository.token.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NewTokenRequest(
	@JsonProperty("secret_id") val secretId: String,
	@JsonProperty("secret_key") val secretKey: String
)
