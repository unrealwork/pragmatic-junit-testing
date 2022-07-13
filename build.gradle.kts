object Versions {
    const val JUNIT = "4.13.2"
}

plugins {
    java
    checkstyle
    jacoco
    id("org.sonarqube") version "3.4.0.2513"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:${Versions.JUNIT}")
}

sonarqube {
    properties {
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.projectKey", "unrealwork_pragmatic-junit-testing")
        property("sonar.organization", "unrealwork-github")
        property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/test/jacoco.xml")
    }
}


