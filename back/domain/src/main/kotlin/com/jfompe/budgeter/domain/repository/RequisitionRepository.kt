package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.requisition.Requisition

interface RequisitionRepository {

	fun createRequisition(institutionId: String, agreementId: String, lang: String, redirectUri: String): Requisition

	fun getRequisition(id: String): Requisition

}