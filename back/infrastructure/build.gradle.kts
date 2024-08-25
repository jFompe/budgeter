plugins {
    kotlin("jvm")
    id("java")
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.20"
    kotlin("kapt") version "1.9.20"
}

group = "com.jfompe.budgeter"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

allOpen {
    annotation("org.springframework.context.annotation.Configuration")
}

dependencies {
    implementation(project(":domain"))
    implementation("org.springframework:spring-beans:6.1.8")
    implementation("org.springframework.boot:spring-boot-starter-web:3.3.3")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:4.1.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.1")
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}