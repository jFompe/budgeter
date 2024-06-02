package com.jfompe.budgeter.application.api.account.controller

import com.jfompe.budgeter.application.api.account.mapper.AccountCreationMapper
import com.jfompe.budgeter.application.api.account.mapper.RequisitionDTOMapper
import com.jfompe.budgeter.application.api.account.model.AccountCreationDTO
import com.jfompe.budgeter.application.api.account.model.RequisitionDTO
import com.jfompe.budgeter.domain.model.account.AccountDetails
import com.jfompe.budgeter.domain.usecase.account.CreateAccountRequisitionUseCase
import com.jfompe.budgeter.domain.usecase.account.GetAccountsDetailsUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountController(
	private val createAccountRequisitionUseCase: CreateAccountRequisitionUseCase,
	private val getAccountRequisitionUseCase: GetAccountsDetailsUseCase,
	private val accountCreationMapper: AccountCreationMapper,
	private val requisitionDTOMapper: RequisitionDTOMapper
): AccountApi {

	override fun createAccountRequisition(accountCreationDTO: AccountCreationDTO): ResponseEntity<RequisitionDTO> =
		accountCreationMapper.toDomain(accountCreationDTO)
			.let { createAccountRequisitionUseCase.execute(it) }
			.let { requisitionDTOMapper.toDTO(it) }
			.let {
				ResponseEntity
				.status(HttpStatus.CREATED)
				.header("X-Requisition-ID", it.id)
				.body(it)
			}

	override fun getAccountsDetails(requisitionId: String): ResponseEntity<List<AccountDetails>> =
		getAccountRequisitionUseCase.execute(requisitionId)
			.let { ResponseEntity.ok(it) }

}