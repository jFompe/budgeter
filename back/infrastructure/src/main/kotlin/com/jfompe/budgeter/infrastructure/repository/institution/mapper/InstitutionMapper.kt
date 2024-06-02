package com.jfompe.budgeter.infrastructure.repository.institution.mapper

import com.jfompe.budgeter.domain.model.institution.InstitutionDomain
import com.jfompe.budgeter.infrastructure.repository.institution.model.Institution
import org.mapstruct.Mapper

@Mapper
interface InstitutionMapper {

	fun toDomain(institution: Institution): InstitutionDomain

}