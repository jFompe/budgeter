package com.jfompe.budgeter.infrastructure.repository.agreement

import com.jfompe.budgeter.infrastructure.configuration.GoCardlessConfiguration
import com.jfompe.budgeter.infrastructure.repository.agreement.model.AgreementRequest
import com.jfompe.budgeter.infrastructure.repository.agreement.model.AgreementResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
	name = "agreementFeignClient",
	url = "\${services.gocardless.url.base}",
	configuration = [GoCardlessConfiguration::class])
interface AgreementFeignClient {

	@PostMapping(path = ["\${services.gocardless.url.agreements}"])
	fun createAgreement(agreementRequest: AgreementRequest): AgreementResponse

}