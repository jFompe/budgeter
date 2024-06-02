package com.jfompe.budgeter.domain.usecase.account

import com.jfompe.budgeter.domain.model.account.AccountDetails
import com.jfompe.budgeter.domain.repository.AccountRepository
import com.jfompe.budgeter.domain.repository.RequisitionRepository

class GetAccountsDetailsUseCase(
	private val requisitionRepository: RequisitionRepository,
	private val accountRepository: AccountRepository
) {

	fun execute(requisitionId: String): List<AccountDetails> =
		requisitionRepository.getRequisition(requisitionId)
			.accounts
			.mapNotNull { accountRepository.getAccountDetails(it) }

}