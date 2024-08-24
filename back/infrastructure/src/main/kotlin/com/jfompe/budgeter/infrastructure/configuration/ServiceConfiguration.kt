package com.jfompe.budgeter.infrastructure.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.jfompe.budgeter.domain.model.category.CategoriesConfig
import com.jfompe.budgeter.domain.service.TransactionCategorizerService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import java.nio.charset.StandardCharsets

@Configuration
class ServiceConfiguration {

	@Bean
	fun categoriesConfig(
		resourceLoader: ResourceLoader
	): CategoriesConfig {
		val objectMapper = ObjectMapper(YAMLFactory()).registerKotlinModule()
		val resource: Resource = resourceLoader.getResource("classpath:expense-categories.yaml")
		val content = resource.getContentAsString(StandardCharsets.UTF_8)
		return objectMapper.readValue(content, CategoriesConfig::class.java).also { println(it) }
	}

	@Bean
	fun transactionCategorizerService(
		categoriesConfig: CategoriesConfig
	) = TransactionCategorizerService(categoriesConfig)

}