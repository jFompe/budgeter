package com.jfompe.budgeter.application.api.account.mapper

import com.jfompe.budgeter.application.api.account.model.AccountCreationDTO
import com.jfompe.budgeter.domain.model.account.AccountCreation
import org.mapstruct.Mapper

@Mapper
interface AccountCreationMapper {

	fun toDomain(accountCreationDTO: AccountCreationDTO): AccountCreation

}