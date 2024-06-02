package com.jfompe.budgeter.application.api.transaction.controller

import com.jfompe.budgeter.application.api.account.controller.AccountApi
import com.jfompe.budgeter.application.api.transaction.controller.TransactionApi.Companion.CONTEXT
import com.jfompe.budgeter.domain.model.account.Transaction
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping(CONTEXT)
interface TransactionApi {

	@GetMapping("/transactions")
	@Tag(name = "4. Get the list of transactions")
	fun getTransactions(
		@PathVariable accountId: String
	): ResponseEntity<List<Transaction>>

	companion object {
		const val CONTEXT = AccountApi.CONTEXT + "/{accountId}"
	}
}