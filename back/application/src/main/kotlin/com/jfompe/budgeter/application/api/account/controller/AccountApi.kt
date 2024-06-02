package com.jfompe.budgeter.application.api.account.controller

import com.jfompe.budgeter.application.api.account.controller.AccountApi.Companion.CONTEXT
import com.jfompe.budgeter.application.api.account.model.AccountCreationDTO
import com.jfompe.budgeter.application.api.account.model.RequisitionDTO
import com.jfompe.budgeter.domain.model.account.AccountDetails
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping(CONTEXT)
interface AccountApi {

	@PostMapping
	@Tag(name = "2. Create an account requisition")
	fun createAccountRequisition(
		@RequestBody accountCreationDTO: AccountCreationDTO
	): ResponseEntity<RequisitionDTO>

	@GetMapping("/{requisitionId}")
	@Tag(name = "3. Get the list of available accounts from the updated requisition")
	fun getAccountsDetails(
		@PathVariable requisitionId: String
	): ResponseEntity<List<AccountDetails>>

	companion object {
		const val CONTEXT = "/api/v1/accounts"
	}
}