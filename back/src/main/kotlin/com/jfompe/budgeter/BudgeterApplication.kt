package com.jfompe.budgeter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BudgeterApplication

fun main(args: Array<String>) {
	runApplication<BudgeterApplication>(*args)
}
