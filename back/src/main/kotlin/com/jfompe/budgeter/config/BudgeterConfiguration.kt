package com.jfompe.budgeter.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(ExpenseCategoriesProperties::class)
class BudgeterConfiguration