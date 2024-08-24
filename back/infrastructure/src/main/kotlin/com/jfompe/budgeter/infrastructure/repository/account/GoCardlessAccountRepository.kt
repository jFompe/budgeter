package com.jfompe.budgeter.infrastructure.repository.account

import com.jfompe.budgeter.domain.model.account.AccountDetailsDomain
import com.jfompe.budgeter.domain.model.account.BalanceDomain
import com.jfompe.budgeter.domain.model.account.TransactionDomain
import com.jfompe.budgeter.domain.repository.AccountRepository
import com.jfompe.budgeter.infrastructure.repository.account.mapper.AccountDetailsMapper
import com.jfompe.budgeter.infrastructure.repository.account.mapper.BalanceMapper
import com.jfompe.budgeter.infrastructure.repository.account.mapper.TransactionMapper

class GoCardlessAccountRepository(
	private val accountFeignClient: AccountFeignClient,
	private val accountDetailsMapper: AccountDetailsMapper,
	private val transactionMapper: TransactionMapper,
	private val balanceMapper: BalanceMapper
) : AccountRepository {

	override fun getAccountDetails(accountId: String): AccountDetailsDomain? =
		try {
			accountFeignClient.getAccountDetails(accountId)
				.let { accountDetailsMapper.toDomain(accountId, it.account) }
		} catch (e: Exception) {
			null
		}

	override fun getTransactions(accountId: String): List<TransactionDomain> =
		accountFeignClient.getTransactions(accountId)
			.transactions
			.let { it.booked + it.pending }
			.let { transactionMapper.toDomain(it) }

	override fun getBalance(accountId: String): BalanceDomain =
		accountFeignClient.getBalances(accountId).balances
			.first { it.balanceType == "openingBooked" }
			.let { balanceMapper.toDomain(it) }

}