plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.bundles.kotlin.result)
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.domain"
}
