object Dependencies {

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin_v7_0_0_alpha14}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_v1_4_32}"
        const val stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_v1_4_32}"
        const val stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin_v1_4_32}"
        const val gradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_v1_4_32}"
        const val serializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin_v1_4_32}"
    }

    object KotlinX {
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.ktx_v1_4_3}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.ktx_v1_4_3}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat"
        const val annotation = "androidx.annotation:annotation:${Versions.androidx_annotation_v1_2_0}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx_v1_3_2}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.androidx_v1_3_0_alpha07}"
        const val fragmentTesting =
            "androidx.fragment:fragment-testing:${Versions.androidx_v1_3_0_alpha07}"
        const val activity = "androidx.activity:activity:${Versions.androidX_activity_v1_2_0_alpha07}"
        const val ktx = "androidx.core:core-ktx:${Versions.AndroidX.ktx}"
        const val swiperefreshlayout =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.androidx_swipeRefreshLayout_v1_1_0}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerView}"
    }

    object ProtoBuf {
        const val gradlePlugin = "com.google.protobuf:protobuf-gradle-plugin:${Versions.protobuf_v0_8_15}"
    }

    object Jetpack {

        object Lifecycle {
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.Jetpack.lifecycle}"
            const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Jetpack.lifecycle}"
            const val savedState = "androidx.savedstate:savedstate-ktx:${Versions.Jetpack.savedState}"
            const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Jetpack.lifecycle}"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:${Versions.Jetpack.lifecycle}"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Jetpack.lifecycle}"
            const val extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.Jetpack.lifecycle_ext}"
            const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.Jetpack.lifecycle}"
        }

        object Room {
            const val room = "androidx.room:room-runtime:${Versions.Jetpack.room}"
            const val roomCompiler = "androidx.room:room-compiler:${Versions.Jetpack.room}"
            const val roomRx = "androidx.room:room-rxjava2:${Versions.Jetpack.room}"
        }

        object Navigation {
            const val navigationUi =
                "androidx.navigation:navigation-fragment-ktx:${Versions.Jetpack.navigation}"
            const val navigationFragment =
                "androidx.navigation:navigation-ui-ktx:${Versions.Jetpack.navigation}"
            const val navigationSafeArgsPlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.navigation}"
            const val safeArgs =
                "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Jetpack.navigation}"
        }

        object Compose {
            const val material = "com.google.android.material:material:${Versions.material}"
        }
    }

    object Hilt {
        const val core = "com.google.dagger:hilt-core:${Versions.Hilt.daggerVersion}"
        const val android = "com.google.dagger:hilt-android:${Versions.Hilt.daggerVersion}"
        const val common = "com.google.dagger:hilt-common:${Versions.Hilt.daggerVersion}"
        const val dagger_compiler = "com.google.dagger:hilt-compiler:${Versions.Hilt.daggerVersion}"
        const val androidx_compiler = "androidx.hilt:hilt-compiler:${Versions.Hilt.androidxVersion}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.Hilt.daggerVersion}"
        const val plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.Hilt.daggerVersion}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Libraries.retrofit}"
        const val moshi = "com.squareup.moshi:moshi:${Versions.Libraries.moshi}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${Versions.Libraries.retrofit}"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.Libraries.moshi}"
        const val moshiCodegen =
            "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Libraries.moshi}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.Libraries.okhttp}"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Libraries.okhttp}"

        object Moshi {
            const val core = "com.squareup.moshi:moshi:${Versions.Libraries.moshi}"
            const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Libraries.moshi}"
            const val reflection = "com.squareup.moshi:moshi-kotlin:${Versions.Libraries.moshi}"
        }
    }

    object CodeQuality {
        const val allOpenPlugin = "org.jetbrains.kotlin:kotlin-allopen:${Versions.kotlin_v1_4_32}"
        const val detektPlugin =
            "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt_v1_9_1}"
        const val ktlintPlugin = "org.jlleitschuh.gradle:ktlint-gradle:${Versions.ktLint_v9_2_1}"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.codeQuality_leakCanary_v2_7}"
        const val api = "com.android.tools.lint:lint-api:${Versions.codeQuality_leakCanary_v2_7}"
        const val checks = "com.android.tools.lint:lint-checks:${Versions.codeQuality_leakCanary_v2_7}"
        const val tests = "com.android.tools.lint:lint-tests:${Versions.codeQuality_leakCanary_v2_7}"
        const val jacoco = "org.jacoco:org.jacoco.core:${Versions.Test.jacoco}"
    }

    object Room {
        val i_runtime = "androidx.room:room-runtime:${Versions.roomVersion}"
        val i_roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
        val t_testing = "androidx.room:room-testing:${Versions.roomVersion}"
        val k_compiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    }

    object Compose {
        val i_compiler = "androidx.compose.compiler:compiler:${Versions.composeExtVersion}"
        val i_materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.composeExtVersion}"
        val i_materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.composeExtVersion}"
        val i_ui = "androidx.compose.ui:ui:${Versions.composeExtVersion}"
        //tooling support (previews, etc.)
        val i_uiTooling = "androidx.compose.ui:ui-tooling:${Versions.composeExtVersion}"
        //foundation (border, background, shapes, image, scroll, animations..)
        val i_foundation = "androidx.compose.foundation:foundation:${Versions.composeExtVersion}"
        //material design
        val i_material = "androidx.compose.material:material:${Versions.composeExtVersion}"
        // Integration with activities
        val i_activity = "androidx.activity:activity-compose:${Versions.composeActivity}"
        // Integration with ViewModels
        val i_lifecycle = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeExt2Version}"
        //integration with observables
        val i_runtime = "androidx.compose.runtime:runtime-livedata:${Versions.composeExtVersion}"
        val i_weatherIcons = "br.com.devsrsouza.compose.icons.android:erikflowers-weather-icons:${Versions.composeIconsVersion}"
        val i_fontAwesome = "br.com.devsrsouza.compose.icons.android:font-awesome:${Versions.composeIconsVersion}"
        val ati_junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.composeExtVersion}"
    }

    object Dispatch {
        const val i_core = "com.rickbusarow.dispatch:dispatch-core:${Versions.coroutines_dispatch}"
        const val i_lifecycle = "com.rickbusarow.dispatch:dispatch-android-lifecycle:${Versions.coroutines_dispatch}"
        // This provides :dispatch-android-lifecycle via "api", so you don't need to declare both
        const val i_lifecycleExt = "com.rickbusarow.dispatch:dispatch-android-lifecycle-extensions:${Versions.coroutines_dispatch}"
        const val i_viewModel = "com.rickbusarow.dispatch:dispatch-android-viewmodel:${Versions.coroutines_dispatch}"
        const val ti_coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.ktx_v1_4_3}"
        //only required if junit5 not established otherwise
        const val ti_test = "com.rickbusarow.dispatch:dispatch-test:${Versions.coroutines_dispatch}"
        // This provides :dispatch-test via "api"
        const val ti_junit5 = "com.rickbusarow.dispatch:dispatch-test-junit5:${Versions.coroutines_dispatch}"
        const val ati_espresso = "com.rickbusarow.dispatch:dispatch-android-espresso:${Versions.coroutines_dispatch}"
    }

    object Util {
        const val timber = "com.jakewharton.timber:timber:${Versions.Libraries.timber}"
        const val easyPermissions = "com.vmadalin:easypermissions-ktx:${Versions.easyPermissions}"
        const val dataStore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
    }

    object Image {
        const val glide = "com.github.bumptech.glide:glide:${Versions.Libraries.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.Libraries.glide}"
        const val weatherView = "com.github.MatteoBattilana:WeatherView:${Versions.weatherView_v3_0_0}"
    }

    object Test {
        const val junit5_plugin = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5_plugin_v1_7_1_1}"
        const val junit = "junit:junit:${Versions.Test.junit}"
        const val core = "androidx.test:core:${Versions.Test.core}"
        const val arch = "android.arch.core:core-testing:${Versions.Jetpack.lifecycle}"
        const val mockitoKotlin =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.Test.mockitokotlin}"
        const val mockK = "io.mockk:mockk:${Versions.Test.mockk}"
        const val assertJ = "org.assertj:assertj-core:${Versions.Test.assertJ}"
        const val junit5_api = "org.junit.jupiter:junit-jupiter-api:${Versions.Test.junit5}"
        const val junit5_engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.Test.junit5}"
    }

    object AndroidTest {
        const val idlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.AndroidTest.espresso}"
        const val runner = "androidx.test:runner:${Versions.AndroidTest.runner}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidTest.espresso}"
        const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.AndroidTest.espresso}"
        const val rules = "androidx.test:rules:${Versions.AndroidTest.rules}"
        const val truth = "androidx.test.ext:truth:${Versions.AndroidTest.truth}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidTest.junit}"
        const val mockitoAndroid = "org.mockito:mockito-android:${Versions.AndroidTest.mockito}"
        const val mockK = "io.mockk:mockk-android:${Versions.AndroidTest.mockk}"
        const val hamcrest = "org.hamcrest:hamcrest:${Versions.AndroidTest.hamcrest}"
    }
}