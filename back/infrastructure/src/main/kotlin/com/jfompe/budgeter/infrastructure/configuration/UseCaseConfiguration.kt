package com.jfompe.budgeter.infrastructure.configuration

import com.jfompe.budgeter.domain.repository.AccountRepository
import com.jfompe.budgeter.domain.repository.AgreementRepository
import com.jfompe.budgeter.domain.repository.InstitutionRepository
import com.jfompe.budgeter.domain.repository.RequisitionRepository
import com.jfompe.budgeter.domain.usecase.account.CreateAccountRequisitionUseCase
import com.jfompe.budgeter.domain.usecase.account.GetAccountsDetailsUseCase
import com.jfompe.budgeter.domain.usecase.institution.GetInstitutionsByCountryUseCase
import com.jfompe.budgeter.domain.usecase.transaction.GetAccountTransactionUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseConfiguration {

	@Bean
	fun createAccountRequisitionUseCase(
		institutionsRepository: InstitutionRepository,
		agreementRepository: AgreementRepository,
		requisitionRepository: RequisitionRepository
	) = CreateAccountRequisitionUseCase(institutionsRepository, agreementRepository, requisitionRepository)

	@Bean
	fun getAccountRequisitionUseCase(
		requisitionRepository: RequisitionRepository,
		accountRepository: AccountRepository
	) = GetAccountsDetailsUseCase(requisitionRepository, accountRepository)

	@Bean
	fun getInstitutionsByCountryUseCase(
		institutionsRepository: InstitutionRepository
	) = GetInstitutionsByCountryUseCase(institutionsRepository)

	@Bean
	fun getAccountTransactionUseCase(
		accountRepository: AccountRepository
	) = GetAccountTransactionUseCase(accountRepository)

}