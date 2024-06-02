package com.jfompe.budgeter.infrastructure.configuration

import com.jfompe.budgeter.domain.repository.TokenRepository
import com.jfompe.budgeter.infrastructure.cache.InMemoryTokenCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.SchedulingConfigurer
import org.springframework.scheduling.config.ScheduledTaskRegistrar
import java.time.Instant
import java.util.concurrent.Executors
import java.util.concurrent.Executor

@Configuration
@EnableScheduling
class ScheduledTokenRetrieverConfiguration(
	private val tokenRepository: TokenRepository,
	private val tokenCache: InMemoryTokenCache
): SchedulingConfigurer {

	@Bean
	fun taskExecutor(): Executor =
		Executors.newSingleThreadScheduledExecutor()

	override fun configureTasks(taskRegistrar: ScheduledTaskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor())
		taskRegistrar.addTriggerTask(
			{
				tokenCache.token = tokenRepository.createToken()
			},
			{
				Instant.now().plusSeconds(
					tokenCache.token
						?.accessExpiresInSeconds?.div(2)?.toLong()
						?: 0
				)
			}
		)
	}

}