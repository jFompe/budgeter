FROM gradle:7.6.3-jdk17 AS build-image

WORKDIR /app

COPY --chown=gradle:gradle build.gradle.kts settings.gradle.kts gradlew gradle.properties ./

COPY --chown=gradle:gradle application ./application
COPY --chown=gradle:gradle domain ./domain
COPY --chown=gradle:gradle infrastructure ./infrastructure

COPY --chown=gradle:gradle gradle ./gradle

RUN ./gradlew --no-daemon build



FROM openjdk:17

WORKDIR /app

COPY --from=build-image app/application/build/libs/application-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]