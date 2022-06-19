import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    application
}

group = "com.github.devlaq"
version = "1.0-dev1"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://maven.kotlindiscord.com/repository/maven-public/")
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")

    implementation("dev.kord:kord-core:v0.8.0-M14")
    implementation("com.kotlindiscord.kord.extensions:kord-extensions:1.5.2-RC1")

    implementation("ch.qos.logback:logback-classic:1.2.11")

    implementation("org.litote.kmongo:kmongo:4.6.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
    kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
}

tasks {
    test {
        useJUnitPlatform()
    }

    run {

    }
}

application {
    mainClass.set("pickaxebot.PickaxeBotKt")
}