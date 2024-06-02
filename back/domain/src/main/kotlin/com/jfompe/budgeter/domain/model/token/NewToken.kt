package com.jfompe.budgeter.domain.model.token

data class NewToken(
	val access: String,
	val accessExpiresInSeconds: Int,
	val refresh: String,
	val refreshExpiresInSeconds: Int
)
