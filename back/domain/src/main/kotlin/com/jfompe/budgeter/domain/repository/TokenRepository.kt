package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.token.NewToken
import com.jfompe.budgeter.domain.model.token.RefreshToken

interface TokenRepository {

	fun createToken(): NewToken

	fun refreshToken(): RefreshToken

}