package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.Balance
import com.jfompe.budgeter.domain.model.Transaction

interface AccountRepository {

	fun getTransactions(accountId: String): List<Transaction>

	fun getBalances(accountId: String): List<Balance>

}