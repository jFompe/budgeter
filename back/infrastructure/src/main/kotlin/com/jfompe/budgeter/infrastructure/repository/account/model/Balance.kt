package com.jfompe.budgeter.infrastructure.repository.account.model

import java.time.LocalDate

data class Balance(
	val balanceAmount: TransactionAmount,
	val balanceType: String,
	val referenceDate: LocalDate
)
