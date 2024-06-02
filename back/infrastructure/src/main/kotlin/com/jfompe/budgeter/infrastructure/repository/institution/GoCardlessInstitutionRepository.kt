package com.jfompe.budgeter.infrastructure.repository.institution

import com.jfompe.budgeter.domain.repository.InstitutionRepository
import com.jfompe.budgeter.domain.model.institution.InstitutionDomain
import com.jfompe.budgeter.infrastructure.repository.institution.mapper.InstitutionMapper

class GoCardlessInstitutionRepository(
	private val institutionFeignClient: InstitutionFeignClient,
	private val institutionMapper: InstitutionMapper
) : InstitutionRepository {

	override fun getInstitutions(countryId: String): List<InstitutionDomain> =
		institutionFeignClient.getInstitutions(countryId)
			.map { institutionMapper.toDomain(it) }

	override fun getInstitution(institutionId: String): InstitutionDomain =
		institutionFeignClient.getInstitution(institutionId)
			.let { institutionMapper.toDomain(it) }

}