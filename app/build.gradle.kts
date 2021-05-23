plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

android {
    compileSdkVersion(Config.compileSdk)
    defaultConfig {
        applicationId = "steve.sample.vendi"
        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode = Config.versionCode
        versionName = Config.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    sourceSets {

        getByName("main") {
            java.srcDirs(
                "src/main/kotlin",
                "src/main/ext",
                "src/config/java",
                "src/config/kotlin",
                "src/integration/kotlin",
                "src/integration/tools"
            )
        }

        getByName("test") {
            java.srcDirs(
                "src/test/kotlin",
                "src/test/ext",
                "src/test/tools"
            )
        }
    }

    lint {
        isAbortOnError = false
        isCheckReleaseBuilds = false
        disable.addAll(
            listOf("MissingDefaultResource", "MissingTranslation", "EarlySyncBuildOutput")
        )
    }

    kotlinOptions {
        jvmTarget = "11"
        useIR = true
        freeCompilerArgs = freeCompilerArgs.plus(listOf(
            "-Xopt-in=kotlin.RequiresOptIn",
            "-Xopt-in=kotlin.RequiresOptIn"
        ))
        languageVersion = "1.4"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.AndroidX.annotation)
    implementation(Dependencies.AndroidX.appcompat)
    implementation(Dependencies.AndroidX.constraintlayout)
    implementation(Dependencies.AndroidX.coreKtx)
    implementation(Dependencies.CodeQuality.leakCanary)
    implementation(Dependencies.Hilt.core)
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.androidCompiler)
    kapt(Dependencies.Hilt.androidx_compiler)
    kapt(Dependencies.Hilt.dagger_compiler)
    implementation(Dependencies.Jetpack.Lifecycle.savedState)
    implementation(Dependencies.Jetpack.Lifecycle.liveDataKtx)
    implementation(Dependencies.Jetpack.Lifecycle.runtimeKtx)
    implementation(Dependencies.Jetpack.Lifecycle.extensions)
    implementation(Dependencies.Jetpack.Lifecycle.commonJava8)
    implementation(Dependencies.Jetpack.Lifecycle.viewModelKtx)
    implementation(Dependencies.Jetpack.Lifecycle.liveDataKtx)
    implementation(Dependencies.Jetpack.Lifecycle.commonJava8)
    implementation(Dependencies.Jetpack.Navigation.navigationFragment)
    implementation(Dependencies.Jetpack.Navigation.navigationUi)
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.stdlib_jdk8)
    implementation(Dependencies.KotlinX.coroutinesCore)
    implementation(Dependencies.KotlinX.coroutinesAndroid)
    implementation(Dependencies.Network.moshi)
    implementation(Dependencies.Network.moshiCodegen)
    kapt(Dependencies.Network.moshiCodegen)
    implementation(Dependencies.Network.Moshi.reflection)
    implementation(Dependencies.Network.moshiAdapters)
    implementation(Dependencies.Network.moshiConverter)
    implementation(Dependencies.Network.retrofit)
    implementation(Dependencies.Network.loggingInterceptor)
    implementation(Dependencies.Util.timber)
    testImplementation(Dependencies.Test.assertJ)
    testImplementation(Dependencies.Test.junit5_api)
    testRuntimeOnly(Dependencies.Test.junit5_engine)
    implementation(Dependencies.AndroidTest.idlingResource)
    androidTestImplementation(Dependencies.AndroidTest.espresso)
    androidTestImplementation(Dependencies.AndroidTest.runner)
    androidTestImplementation(Dependencies.AndroidTest.espressoIntents)
    androidTestImplementation(Dependencies.AndroidTest.hamcrest)
    implementation(Dependencies.Util.dataStore)
    implementation(Dependencies.Room.i_runtime)
    implementation(Dependencies.Room.i_roomKtx)
    testImplementation(Dependencies.Room.t_testing)
    kapt(Dependencies.Room.k_compiler)
    implementation(Dependencies.Compose.i_compiler)
    implementation(Dependencies.Compose.i_materialIconsCore)
    implementation(Dependencies.Compose.i_materialIconsExtended)
    implementation(Dependencies.Compose.i_ui)
    implementation(Dependencies.Compose.i_uiTooling)
    implementation(Dependencies.Compose.i_foundation)
    implementation(Dependencies.Compose.i_material)
    implementation(Dependencies.Compose.i_activity)
    implementation(Dependencies.Compose.i_lifecycle)
    implementation(Dependencies.Compose.i_runtime)
    implementation(Dependencies.Compose.i_weatherIcons)
    implementation(Dependencies.Compose.i_fontAwesome)
    androidTestImplementation(Dependencies.Compose.ati_junit4)
    implementation(Dependencies.Dispatch.i_core)
    implementation(Dependencies.Dispatch.i_lifecycle)
    implementation(Dependencies.Dispatch.i_lifecycleExt)
    implementation(Dependencies.Dispatch.i_viewModel)
    testImplementation(Dependencies.Dispatch.ti_coroutinesTest)
    testImplementation(Dependencies.Dispatch.ti_test)
    testImplementation(Dependencies.Dispatch.ti_junit5)
    androidTestImplementation(Dependencies.Dispatch.ati_espresso)
    implementation("androidx.datastore:datastore-core:1.0.0-alpha08")
    implementation(kotlin("reflect"))
    implementation("androidx.compose.ui:ui-viewbinding:1.0.0-beta04")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
        kotlinOptions {
            languageVersion = "1.4"
        }
    }
}


//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
//    implementation("androidx.activity:activity-compose:1.3.0-alpha06")
//    // (Required) Writing and executing Unit Tests on the JUnit Platform
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
//    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
//
//    // (Optional) If you need "Parameterized Tests"
//    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
//
//    // (Optional) If you also have JUnit 4-based tests
//    testImplementation("junit:junit:4.13")
//    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.7.1")
//
//    androidTestImplementation("androidx.test.ext:junit:1.1.2")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
//    // 4) Jupiter API & Test Runner, if you don't have it already
//    androidTestImplementation("androidx.test:runner:1.2.0")
//    androidTestImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
//
//    // 5) The instrumentation test companion libraries
//    androidTestImplementation("de.mannodermaus.junit5:android-test-core:1.2.2")
//    androidTestRuntimeOnly("de.mannodermaus.junit5:android-test-runner:1.2.2")
//
//    testImplementation("io.mockk:mockk:1.10.6")