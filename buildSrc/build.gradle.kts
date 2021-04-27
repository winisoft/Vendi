import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `java-library`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {

//    implementation("com.android.tools.build", "gradle", "4.1.3")
//
//    implementation("org.jetbrains.kotlin", "kotlin-gradle-plugin", "1.4.32")
//
//    implementation("org.jetbrains.kotlin", "kotlin-stdlib", "1.4.32")
//
//    localGroovy()
}

tasks {
    withType(KotlinCompile::class) {
        compileKotlin {
            kotlinOptions {
                languageVersion = "1.4"
            }
        }
    }
}