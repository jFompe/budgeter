
dependencyResolutionManagement {
	repositories {
		mavenCentral()
	}
}

pluginManagement {
	repositories {
		mavenCentral()
	}

	val springBootVersion: String by settings
	val dependencyManagementVersion: String by settings
	val kotlinVersion: String by settings
	plugins {
		id("org.springframework.boot") version springBootVersion
		id("io.spring.dependency-management") version dependencyManagementVersion
		kotlin("jvm") version kotlinVersion
		kotlin("plugin.spring") version kotlinVersion
	}
}

rootProject.name = "budgeter"
include("domain")
include("application")
include("infrastructure")
