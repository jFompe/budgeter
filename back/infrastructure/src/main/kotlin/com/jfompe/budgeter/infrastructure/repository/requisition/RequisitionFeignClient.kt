package com.jfompe.budgeter.infrastructure.repository.requisition

import com.jfompe.budgeter.infrastructure.configuration.GoCardlessConfiguration
import com.jfompe.budgeter.infrastructure.repository.requisition.model.Requisition
import com.jfompe.budgeter.infrastructure.repository.requisition.model.RequisitionRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(
	name = "requisitionFeignClient",
	url = "\${services.gocardless.url.base}",
	configuration = [GoCardlessConfiguration::class])
interface RequisitionFeignClient {

	@PostMapping(path = ["\${services.gocardless.url.requisitions}"])
	fun createRequisition(
		@RequestBody requisitionRequest: RequisitionRequest
	): Requisition

	@GetMapping(path = ["\${services.gocardless.url.requisitions}{id}/"])
	fun getRequisition(
		@PathVariable id: String
	): Requisition

}