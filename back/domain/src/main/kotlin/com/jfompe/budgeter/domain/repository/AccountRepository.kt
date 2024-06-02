package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.account.AccountDetailsDomain
import com.jfompe.budgeter.domain.model.account.BalanceDomain
import com.jfompe.budgeter.domain.model.account.TransactionDomain

interface AccountRepository {

	fun getAccountDetails(accountId: String): AccountDetailsDomain?

	fun getTransactions(accountId: String): List<TransactionDomain>

	fun getBalance(accountId: String): BalanceDomain

}