package com.jfompe.budgeter.domain.usecase.transaction

import com.jfompe.budgeter.domain.model.account.Transaction
import com.jfompe.budgeter.domain.repository.AccountRepository
import kotlin.math.pow

class GetAccountTransactionUseCase(
	private val accountRepository: AccountRepository
) {

	fun execute(accountId: String): List<Transaction> {
		var currentBalance = accountRepository.getBalance(accountId).amount

		return accountRepository.getTransactions(accountId)
			.distinctBy { Triple(it.concept, it.amount, it.date) }
			.sortedByDescending { it.date }
			.map {
				val transactionWithBalance = it.copy(balance = currentBalance)
				currentBalance = (currentBalance - it.amount).round(decimals = 2)
				transactionWithBalance
			}
	}


	private fun Double.round(decimals: Int): Double {
		val powerOfTen = 10.0.pow(decimals)
		return Math.round(this * powerOfTen) / powerOfTen
	}
}