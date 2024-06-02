package com.jfompe.budgeter.infrastructure.repository.requisition.mapper

import com.jfompe.budgeter.domain.model.requisition.RequisitionDomain
import com.jfompe.budgeter.infrastructure.repository.requisition.model.Requisition
import org.mapstruct.Mapper

@Mapper
interface RequisitionMapper {

	fun toDomain(requisition: Requisition): RequisitionDomain

}