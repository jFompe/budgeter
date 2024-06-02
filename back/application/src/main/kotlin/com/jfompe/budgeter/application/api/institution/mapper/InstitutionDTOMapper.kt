package com.jfompe.budgeter.application.api.institution.mapper

import com.jfompe.budgeter.application.api.institution.model.InstitutionDTO
import com.jfompe.budgeter.domain.model.institution.Institution
import org.mapstruct.Mapper

@Mapper
interface InstitutionDTOMapper {

	fun toDTO(institution: Institution): InstitutionDTO

}