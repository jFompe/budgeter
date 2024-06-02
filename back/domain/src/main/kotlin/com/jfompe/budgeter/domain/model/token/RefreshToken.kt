package com.jfompe.budgeter.domain.model.token

data class RefreshToken(
	val access: String,
	val accessExpiresInSeconds: Int
)
