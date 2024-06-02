package com.jfompe.budgeter.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.jfompe.budgeter"])
class BudgeterApplication

fun main(args: Array<String>) {
	runApplication<BudgeterApplication>(*args)
}