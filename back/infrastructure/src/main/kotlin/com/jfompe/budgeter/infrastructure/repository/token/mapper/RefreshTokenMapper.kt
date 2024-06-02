package com.jfompe.budgeter.infrastructure.repository.token.mapper

import com.jfompe.budgeter.domain.model.token.RefreshToken
import com.jfompe.budgeter.infrastructure.repository.token.model.RefreshTokenResponse
import org.mapstruct.Mapper

@Mapper
interface RefreshTokenMapper {

	fun toDomain(refreshTokenResponse: RefreshTokenResponse): RefreshToken

}