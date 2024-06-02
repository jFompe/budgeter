package com.jfompe.budgeter.domain.usecase.account

import com.jfompe.budgeter.domain.model.account.AccountCreation
import com.jfompe.budgeter.domain.model.requisition.Requisition
import com.jfompe.budgeter.domain.repository.AgreementRepository
import com.jfompe.budgeter.domain.repository.InstitutionRepository
import com.jfompe.budgeter.domain.repository.RequisitionRepository

class CreateAccountRequisitionUseCase(
	private val institutionRepository: InstitutionRepository,
	private val agreementRepository: AgreementRepository,
	private val requisitionRepository: RequisitionRepository
) {

	fun execute(accountCreation: AccountCreation): Requisition {
		val institution = institutionRepository.getInstitution(accountCreation.institutionId)
		val agreement = agreementRepository.createAgreement(accountCreation.institutionId, institution.maxDays)
		return requisitionRepository.createRequisition(
			institutionId = accountCreation.institutionId,
			agreementId = agreement.id,
			lang = accountCreation.lang,
			redirectUri = accountCreation.redirectUri
		)
	}

}