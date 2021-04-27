buildscript {

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath(Dependencies.Android.gradlePlugin)
        classpath(Dependencies.Kotlin.gradlePlugin)
        classpath(Dependencies.Hilt.plugin)
        classpath(Dependencies.Test.junit5_plugin)
        classpath(Dependencies.Jetpack.Navigation.navigationSafeArgsPlugin)
        classpath(Dependencies.CodeQuality.detektPlugin)
        classpath(Dependencies.CodeQuality.ktlintPlugin)
        classpath(Dependencies.CodeQuality.jacoco)
    }
}

subprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        maven(url = uri("https://kotlin.bintray.com/kotlinx"))
    }
}

allprojects {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        maven(url = uri("https://kotlin.bintray.com/kotlinx"))
    }
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
        kotlinOptions {
            languageVersion = "1.4"
        }
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.9.1"
}

tasks {
    get("detekt").setProperty("jvmTarget", JavaVersion.VERSION_11.toString())
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
