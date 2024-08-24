package com.jfompe.budgeter.infrastructure.repository.account.mapper

import com.jfompe.budgeter.domain.model.account.AccountDetailsDomain
import com.jfompe.budgeter.infrastructure.repository.account.model.AccountDetails
import org.mapstruct.Mapper

@Mapper
interface AccountDetailsMapper {

	fun toDomain(id: String, accountDetails: AccountDetails): AccountDetailsDomain

}