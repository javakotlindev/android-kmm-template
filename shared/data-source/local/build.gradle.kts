plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:common"))
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.local"
}
