import org.gradle.api.artifacts.Dependency

object Versions {

    const val androidGradlePlugin_v7_0_0_alpha14 = "7.0.0-alpha14"

    const val kotlin_v1_4_32 = "1.4.32"
    const val ktx_v1_4_3: String = "1.4.3"
    const val coreKtx_v1_3_2: String = "1.3.2"

    const val detekt_v1_9_1 = "1.9.1"
    const val ktLint_v9_2_1 = "9.2.1"
    const val junit5_plugin_v1_7_1_1 = "1.7.1.1"

    const val androidX_activity_v1_2_0_alpha07 = "1.2.0-alpha07"
    const val androidx_appcompat_v1_2_0 = "1.2.0"
    const val androidx_annotation_v1_2_0 = "1.2.0"
    const val androidx_constraintLayout = "2.0.0-beta8"
    const val androidx_v1_3_0_alpha07 = "1.3.0-alpha07"
    const val androidx_recyclerView = "1.2.0-alpha05"
    const val androidx_swipeRefreshLayout_v1_1_0 = "1.1.0"

    const val jetpack_lifecycle_v2_3_4 = "2.3.4"
    const val protobuf_v0_8_15: String = "0.8.15"

    const val codeQuality_leakCanary_v2_7 = "2.7"
    const val codeQuality_lint_v26_6_3 = "26.6.3"
    const val coroutines_dispatch = "1.0.0-beta08"

    const val composeExt2Version = "1.0.0-alpha03"
    const val composeExtVersion = "1.0.0-beta04"
    const val composeIconsVersion = "0.2.0"
    const val composeActivity = "1.3.0-alpha06"

    const val roomVersion = "2.2.6"
    const val easyPermissions = "0.1.0"
    const val dataStore = "1.0.0-alpha08"
    const val material = "1.1.0"

    const val weatherView_v3_0_0 = "3.0.0"

    object AndroidX: Map<String, String> by mapOf() {
        const val ktx = "1.3.1"
    }

    object Jetpack {
        const val lifecycle = "2.3.1"
        const val commonJava8 = "2.3.0"
        const val lifecycle_ext = "2.2.0"
        const val room = "2.2.5"
        const val navigation = "2.3.5"
        const val savedState = "1.1.0"
    }

    object Hilt {
        const val daggerVersion = "2.33-beta"
        const val androidxVersion = "1.0.0-alpha03"
    }

    object Libraries {
        const val glide = "4.11.0"
        const val timber = "4.7.1"
        const val dagger = "2.28.3"
        const val retrofit = "2.9.0"
        const val moshi = "1.9.3"
        const val okhttp = "4.8.0"
        const val assistedInject = "0.5.2"
    }

    object Test {
        const val junit = "4.13"
        const val core = "1.2.0"
        const val mockitokotlin = "2.2.0"
        const val jacoco = "0.8.5"
        const val mockk = "1.10.6"
        const val assertJ = "3.12.2"
        const val junit5 = "5.7.0"
    }

    object AndroidTest {
        const val junit = "1.1.0"
        const val rules = "1.1.1"
        const val runner = "1.4.0-alpha05"
        const val espresso = "3.4.0-alpha05"
        const val truth = "1.1.0"
        const val mockito = "3.3.3"
        const val mockk = "1.10.6"
        const val hamcrest = "2.2"
    }
}