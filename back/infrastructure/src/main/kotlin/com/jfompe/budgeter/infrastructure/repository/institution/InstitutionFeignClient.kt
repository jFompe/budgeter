package com.jfompe.budgeter.infrastructure.repository.institution

import com.jfompe.budgeter.infrastructure.configuration.GoCardlessConfiguration
import com.jfompe.budgeter.infrastructure.repository.institution.model.Institution
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(
	name = "institutionFeignClient",
	url = "\${services.gocardless.url.base}",
	configuration = [GoCardlessConfiguration::class])
interface InstitutionFeignClient {

	@GetMapping("\${services.gocardless.url.institutions}")
	fun getInstitutions(@RequestParam("country") countryId: String): List<Institution>

	@GetMapping("\${services.gocardless.url.institutions}{id}")
	fun getInstitution(@PathVariable("id") institutionId: String): Institution

}