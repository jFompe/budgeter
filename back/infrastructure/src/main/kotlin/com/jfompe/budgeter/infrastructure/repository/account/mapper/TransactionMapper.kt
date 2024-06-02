package com.jfompe.budgeter.infrastructure.repository.account.mapper

import com.jfompe.budgeter.domain.model.account.TransactionDomain
import com.jfompe.budgeter.infrastructure.repository.account.model.Transaction
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface TransactionMapper {

	@Mapping(source = "transactionAmount.amount", target = "amount")
	@Mapping(source = "transactionAmount.currency", target = "currency")
	@Mapping(source = "remittanceInformationUnstructured", target = "concept")
	@Mapping(source = "valueDate", target = "date")
	@Mapping(target = "balance", ignore = true)
	fun toDomain(transaction: Transaction): TransactionDomain

	fun toDomain(transactions: List<Transaction>): List<TransactionDomain>

}