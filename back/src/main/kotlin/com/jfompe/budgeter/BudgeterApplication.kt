package com.jfompe.budgeter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class BudgeterApplication

fun main(args: Array<String>) {
	runApplication<BudgeterApplication>(*args)
}
