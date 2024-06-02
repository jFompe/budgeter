package com.jfompe.budgeter.infrastructure.configuration

import com.jfompe.budgeter.infrastructure.cache.InMemoryTokenCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfiguration {

	@Bean
	fun tokenCache() = InMemoryTokenCache()

}