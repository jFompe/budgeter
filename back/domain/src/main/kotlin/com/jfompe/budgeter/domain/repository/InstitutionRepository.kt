package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.institution.Institution

interface InstitutionRepository {

	fun getInstitutions(countryId: String): List<Institution>

	fun getInstitution(institutionId: String): Institution

}