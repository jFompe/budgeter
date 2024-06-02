package com.jfompe.budgeter.domain.repository

import com.jfompe.budgeter.domain.model.agreement.Agreement

interface AgreementRepository {

	fun createAgreement(institutionId: String, maxDays: Int): Agreement

}