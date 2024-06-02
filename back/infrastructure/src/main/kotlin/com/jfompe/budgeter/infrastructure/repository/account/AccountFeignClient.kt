package com.jfompe.budgeter.infrastructure.repository.account

import com.jfompe.budgeter.infrastructure.configuration.GoCardlessConfiguration
import com.jfompe.budgeter.infrastructure.repository.account.model.AccountDetailsWrapper
import com.jfompe.budgeter.infrastructure.repository.account.model.Balances
import com.jfompe.budgeter.infrastructure.repository.account.model.TransactionsWrapper
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
	name = "accountFeignClient",
	url = "\${services.gocardless.url.base}",
	configuration = [GoCardlessConfiguration::class])
interface AccountFeignClient {

	@GetMapping(path = ["\${services.gocardless.url.accounts.details}"])
	fun getAccountDetails(
		@PathVariable id: String
	): AccountDetailsWrapper

	@GetMapping(path = ["\${services.gocardless.url.accounts.transactions}"])
	fun getTransactions(
		@PathVariable id: String
	): TransactionsWrapper

	@GetMapping(path = ["\${services.gocardless.url.accounts.balances}"])
	fun getBalances(
		@PathVariable id: String
	): Balances

}