plugins {
    application
    checkstyle
    id("se.patrikerdes.use-latest-versions") version "0.2.19"
    id("com.github.ben-manes.versions") version "0.41.0"
    id("org.sonarqube") version "7.0.0.6105"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass = "hexlet.code.App"
}

repositories {
    mavenCentral()
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}

sonar {
    properties {
        property("sonar.projectKey", "ndreyserg_java-project-61")
        property("sonar.organization", "ndreyserg")
    }
}