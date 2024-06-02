package com.jfompe.budgeter.domain.usecase.institution

import com.jfompe.budgeter.domain.model.institution.Institution
import com.jfompe.budgeter.domain.repository.InstitutionRepository

class GetInstitutionsByCountryUseCase(
	private val institutionRepository: InstitutionRepository
) {

	fun execute(countryId: String): List<Institution> =
		institutionRepository.getInstitutions(countryId)
}