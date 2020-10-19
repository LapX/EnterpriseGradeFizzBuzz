import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
}
group = "lapx"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation(
        group = "com.sparkjava", name = "spark-core", version = "2.9.3"
    )
    implementation(
        group = "com.google.code.gson", name = "gson", version = "2.8.6"
    )
    testImplementation(
        group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.3.1"
    )
    testImplementation(
        group = "org.mockito", name = "mockito-core", version = "2.21.0"
    )
    testImplementation(
        group = "org.mockito", name = "mockito-junit-jupiter", version = "2.23.0"
    )
    testImplementation(
        group = "com.google.truth", name = "truth", version = "1.0.1"
    )
    testImplementation(kotlin("test-junit5"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}