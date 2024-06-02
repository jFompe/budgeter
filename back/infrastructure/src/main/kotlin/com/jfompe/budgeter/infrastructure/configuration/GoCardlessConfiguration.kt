package com.jfompe.budgeter.infrastructure.configuration

import com.jfompe.budgeter.infrastructure.cache.InMemoryTokenCache
import feign.RequestInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

@Configuration
class GoCardlessConfiguration {

	@Bean
	fun nordigenBearerTokenRequestInterceptor(
		tokenCache: InMemoryTokenCache
	): RequestInterceptor = RequestInterceptor {
		if (!it.request().url().contains("/token")) {
			it.header(HttpHeaders.AUTHORIZATION, "Bearer ${tokenCache.token?.access}")
		}
	}

	@Bean
	fun nordigenRequestHeadersSetterInterceptor(): RequestInterceptor = RequestInterceptor {
		it.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//		if (it.method() == HttpMethod.POST.name()) {
		it.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//		}
	}

}