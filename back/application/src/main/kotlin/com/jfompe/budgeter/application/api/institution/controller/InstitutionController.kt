package com.jfompe.budgeter.application.api.institution.controller

import com.jfompe.budgeter.application.api.institution.mapper.InstitutionDTOMapper
import com.jfompe.budgeter.application.api.institution.model.InstitutionDTO
import com.jfompe.budgeter.domain.usecase.institution.GetInstitutionsByCountryUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class InstitutionController(
	private val getInstitutionsByCountryUseCase: GetInstitutionsByCountryUseCase,
	private val institutionDTOMapper: InstitutionDTOMapper
): InstitutionApi {

	override fun getInstitutions(countryId: String): ResponseEntity<List<InstitutionDTO>> =
		getInstitutionsByCountryUseCase.execute(countryId)
			.map { institutionDTOMapper.toDTO(it) }
			.let { ResponseEntity.ok(it) }

}