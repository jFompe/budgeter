package com.jfompe.budgeter.infrastructure.repository.token.mapper

import com.jfompe.budgeter.domain.model.token.NewToken
import com.jfompe.budgeter.infrastructure.repository.token.model.NewTokenResponse
import org.mapstruct.Mapper

@Mapper
interface NewTokenMapper {

	fun toDomain(newTokenResponse: NewTokenResponse): NewToken

}