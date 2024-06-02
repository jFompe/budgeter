package com.jfompe.budgeter.infrastructure.configuration

import com.jfompe.budgeter.domain.repository.*
import com.jfompe.budgeter.infrastructure.repository.account.AccountFeignClient
import com.jfompe.budgeter.infrastructure.repository.account.GoCardlessAccountRepository
import com.jfompe.budgeter.infrastructure.repository.account.mapper.AccountDetailsMapper
import com.jfompe.budgeter.infrastructure.repository.account.mapper.BalanceMapper
import com.jfompe.budgeter.infrastructure.repository.account.mapper.TransactionMapper
import com.jfompe.budgeter.infrastructure.repository.agreement.AgreementFeignClient
import com.jfompe.budgeter.infrastructure.repository.agreement.GoCardlessAgreementRepository
import com.jfompe.budgeter.infrastructure.repository.agreement.mapper.AgreementMapper
import com.jfompe.budgeter.infrastructure.repository.institution.GoCardlessInstitutionRepository
import com.jfompe.budgeter.infrastructure.repository.institution.InstitutionFeignClient
import com.jfompe.budgeter.infrastructure.repository.institution.mapper.InstitutionMapper
import com.jfompe.budgeter.infrastructure.repository.requisition.GoCardlessRequisitionRepository
import com.jfompe.budgeter.infrastructure.repository.requisition.RequisitionFeignClient
import com.jfompe.budgeter.infrastructure.repository.requisition.mapper.RequisitionMapper
import com.jfompe.budgeter.infrastructure.repository.token.GoCardlessTokenRepository
import com.jfompe.budgeter.infrastructure.repository.token.TokenFeignClient
import com.jfompe.budgeter.infrastructure.repository.token.mapper.NewTokenMapper
import com.jfompe.budgeter.infrastructure.repository.token.mapper.RefreshTokenMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients(basePackages = ["com.jfompe.budgeter.infrastructure"])
class RepositoryConfiguration {

	@Bean
	fun accountRepository(
		accountFeignClient: AccountFeignClient,
		accountDetailsMapper: AccountDetailsMapper,
		transactionMapper: TransactionMapper,
		balanceMapper: BalanceMapper
	): AccountRepository =
		GoCardlessAccountRepository(accountFeignClient, accountDetailsMapper, transactionMapper, balanceMapper)

	@Bean
	fun agreementRepository(
		agreementFeignClient: AgreementFeignClient,
		agreementMapper: AgreementMapper
	): AgreementRepository = GoCardlessAgreementRepository(agreementFeignClient, agreementMapper)

	@Bean
	fun institutionRepository(
		institutionFeignClient: InstitutionFeignClient,
		instutionMapper: InstitutionMapper
	): InstitutionRepository = GoCardlessInstitutionRepository(institutionFeignClient, instutionMapper)

	@Bean
	fun requisitionRepository(
		requisitionFeignClient: RequisitionFeignClient,
		requisitionMapper: RequisitionMapper
	): RequisitionRepository = GoCardlessRequisitionRepository(requisitionFeignClient, requisitionMapper)

	@Bean
	fun tokenRepository(
		tokenFeignClient: TokenFeignClient,
		newTokenMapper: NewTokenMapper,
		refreshTokenMapper: RefreshTokenMapper,
		@Value("\${services.gocardless.secret.id}") gocardlessSecretId: String,
		@Value("\${services.gocardless.secret.key}") gocardlessSecretKey: String
	): TokenRepository =
		GoCardlessTokenRepository(
			tokenFeignClient, newTokenMapper, refreshTokenMapper, gocardlessSecretId, gocardlessSecretKey)

}