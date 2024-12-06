plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:common"))
            implementation(project(":shared:domain"))
            implementation(project(":shared:data-source:local"))
            implementation(project(":shared:data-source:remote"))
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.data"
}
