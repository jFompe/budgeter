package com.jfompe.budgeter.infrastructure.repository.account.mapper

import com.jfompe.budgeter.domain.model.account.BalanceDomain
import com.jfompe.budgeter.infrastructure.repository.account.model.Balance
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface BalanceMapper {

	@Mapping(source = "balanceAmount.currency", target = "currency")
	@Mapping(source = "balanceAmount.amount", target = "amount")
	@Mapping(source = "referenceDate", target = "date")
	fun toDomain(balances: Balance): BalanceDomain

}