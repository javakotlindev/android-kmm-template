plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:common"))
            implementation(libs.bundles.kotlin.result)
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.domain"
}
