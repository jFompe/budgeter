package com.jfompe.budgeter.infrastructure.repository.requisition

import com.jfompe.budgeter.domain.model.requisition.RequisitionDomain
import com.jfompe.budgeter.domain.repository.RequisitionRepository
import com.jfompe.budgeter.infrastructure.repository.requisition.mapper.RequisitionMapper
import com.jfompe.budgeter.infrastructure.repository.requisition.model.RequisitionRequest
import java.util.*

class GoCardlessRequisitionRepository(
	private val requisitionFeignClient: RequisitionFeignClient,
	private val requisitionMapper: RequisitionMapper
) : RequisitionRepository {
	override fun createRequisition(
		institutionId: String, agreementId: String, lang: String, redirectUri: String
	): RequisitionDomain =
		RequisitionRequest(
			redirect = redirectUri,
			institutionId = institutionId,
			reference = "UserInternalRef_${UUID.randomUUID()}",
			agreement = agreementId,
			userLanguage = lang,
			accountSelection = true,
			redirectImmediate = true
		).let { requisitionFeignClient.createRequisition(it) }
			.let { requisitionMapper.toDomain(it) }

	override fun getRequisition(id: String): RequisitionDomain =
		requisitionFeignClient.getRequisition(id)
			.let { requisitionMapper.toDomain(it) }

}