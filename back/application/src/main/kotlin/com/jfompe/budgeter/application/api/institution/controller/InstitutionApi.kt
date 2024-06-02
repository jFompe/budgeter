package com.jfompe.budgeter.application.api.institution.controller

import com.jfompe.budgeter.application.api.institution.controller.InstitutionApi.Companion.CONTEXT
import com.jfompe.budgeter.application.api.institution.model.InstitutionDTO
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping(CONTEXT)
interface InstitutionApi {

	@GetMapping
	@Tag(name = "1. List institutions")
	fun getInstitutions(
		@RequestParam countryId: String
	): ResponseEntity<List<InstitutionDTO>>

	companion object {
		const val CONTEXT = "/api/v1/institutions"
	}
}