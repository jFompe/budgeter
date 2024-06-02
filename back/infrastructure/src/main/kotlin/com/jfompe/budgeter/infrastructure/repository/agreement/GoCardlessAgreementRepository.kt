package com.jfompe.budgeter.infrastructure.repository.agreement

import com.jfompe.budgeter.domain.model.agreement.AgreementDomain
import com.jfompe.budgeter.domain.repository.AgreementRepository
import com.jfompe.budgeter.infrastructure.repository.agreement.mapper.AgreementMapper
import com.jfompe.budgeter.infrastructure.repository.agreement.model.AgreementRequest

class GoCardlessAgreementRepository(
	private val agreementFeignClient: AgreementFeignClient,
	private val agreementMapper: AgreementMapper
) : AgreementRepository {

	override fun createAgreement(institutionId: String, maxDays: Int): AgreementDomain =
		AgreementRequest(
			institutionId = institutionId,
			maxDays = maxDays,
			accessScope = ACCESS_SCOPES,
			accessValidForDays = ACCESS_VALID_DAYS
		).let { agreementFeignClient.createAgreement(it)  }
			.let { agreementMapper.toDomain(it) }

	companion object {
		val ACCESS_SCOPES = listOf("balances", "details", "transactions")
		val ACCESS_VALID_DAYS = 1
	}
}