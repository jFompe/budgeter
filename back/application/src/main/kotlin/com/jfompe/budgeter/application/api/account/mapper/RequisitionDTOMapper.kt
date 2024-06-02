package com.jfompe.budgeter.application.api.account.mapper

import com.jfompe.budgeter.application.api.account.model.RequisitionDTO
import com.jfompe.budgeter.domain.model.requisition.Requisition
import org.mapstruct.Mapper

@Mapper
interface RequisitionDTOMapper {

	fun toDTO(requisition: Requisition): RequisitionDTO

}