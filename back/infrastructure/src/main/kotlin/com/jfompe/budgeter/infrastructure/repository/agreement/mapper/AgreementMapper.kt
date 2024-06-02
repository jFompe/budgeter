package com.jfompe.budgeter.infrastructure.repository.agreement.mapper

import com.jfompe.budgeter.domain.model.agreement.AgreementDomain
import com.jfompe.budgeter.infrastructure.repository.agreement.model.AgreementResponse
import org.mapstruct.Mapper
import org.mapstruct.ReportingPolicy

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface AgreementMapper {

	fun toDomain(agreementResponse: AgreementResponse): AgreementDomain

}