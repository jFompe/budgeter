package com.jfompe.budgeter.application.api.transaction.controller

import com.jfompe.budgeter.domain.model.account.Transaction
import com.jfompe.budgeter.domain.usecase.transaction.GetAccountTransactionUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TransactionController(
	private val getAccountTransactionUseCase: GetAccountTransactionUseCase
) : TransactionApi {

	override fun getTransactions(accountId: String): ResponseEntity<List<Transaction>> =
		getAccountTransactionUseCase.execute(accountId)
			.let { ResponseEntity.ok(it) }

}