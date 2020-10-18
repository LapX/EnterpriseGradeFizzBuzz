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
    compile(
        group = "com.sparkjava", name = "spark-core", version = "2.9.3"
    )
    testImplementation(kotlin("test-junit5"))
}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}