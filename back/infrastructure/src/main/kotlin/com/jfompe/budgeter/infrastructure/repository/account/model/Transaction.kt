package com.jfompe.budgeter.infrastructure.repository.account.model

import java.time.LocalDate

data class Transaction(
	val transactionAmount: TransactionAmount,
	val valueDate: LocalDate,
	val remittanceInformationUnstructured: String
)
