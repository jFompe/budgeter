package com.jfompe.budgeter.infrastructure.repository.token

import com.jfompe.budgeter.domain.model.token.NewToken
import com.jfompe.budgeter.domain.model.token.RefreshToken
import com.jfompe.budgeter.domain.repository.TokenRepository
import com.jfompe.budgeter.infrastructure.repository.token.mapper.NewTokenMapper
import com.jfompe.budgeter.infrastructure.repository.token.mapper.RefreshTokenMapper
import com.jfompe.budgeter.infrastructure.repository.token.model.NewTokenRequest
import com.jfompe.budgeter.infrastructure.repository.token.model.RefreshTokenRequest

class GoCardlessTokenRepository(
	private val tokenFeignClient: TokenFeignClient,
	private val newTokenMapper: NewTokenMapper,
	private val refreshTokenMapper: RefreshTokenMapper,
	private val nordigenSecretId: String,
	private val nordigenSecretKey: String
) : TokenRepository {
	override fun createToken(): NewToken =
		NewTokenRequest(nordigenSecretId, nordigenSecretKey)
			.let { tokenFeignClient.createToken(it) }
			.let { newTokenMapper.toDomain(it) }

	override fun refreshToken(): RefreshToken =
		RefreshTokenRequest("a")
			.let { tokenFeignClient.refreshToken(it) }
			.let { refreshTokenMapper.toDomain(it) }
}