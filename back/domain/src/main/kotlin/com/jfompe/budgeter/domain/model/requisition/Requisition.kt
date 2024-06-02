package com.jfompe.budgeter.domain.model.requisition

data class Requisition(
	val id: String,
	val redirect: String,
	val status: String,
	val agreement: String,
	val accounts: List<String>,
	val reference: String,
	val lang: String,
	val link: String
)

typealias RequisitionDomain = Requisition
