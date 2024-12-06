plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.bundles.kotlin.result)
            api(libs.kotlinx.coroutines.core)
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.common"
}
