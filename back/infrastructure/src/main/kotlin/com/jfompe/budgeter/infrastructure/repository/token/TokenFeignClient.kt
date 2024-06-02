package com.jfompe.budgeter.infrastructure.repository.token

import com.jfompe.budgeter.infrastructure.configuration.GoCardlessConfiguration
import com.jfompe.budgeter.infrastructure.repository.token.model.NewTokenRequest
import com.jfompe.budgeter.infrastructure.repository.token.model.NewTokenResponse
import com.jfompe.budgeter.infrastructure.repository.token.model.RefreshTokenRequest
import com.jfompe.budgeter.infrastructure.repository.token.model.RefreshTokenResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
	name = "tokenFeignClient",
	url = "\${services.gocardless.url.base}",
	configuration = [GoCardlessConfiguration::class])
interface TokenFeignClient {

	@PostMapping(path = ["\${services.gocardless.url.token.new}"])
	fun createToken(@RequestBody newTokenRequest: NewTokenRequest): NewTokenResponse

	@PostMapping(path = ["\${services.gocardless.url.token.refresh}"])
	fun refreshToken(@RequestBody refreshTokenRequest: RefreshTokenRequest): RefreshTokenResponse

}