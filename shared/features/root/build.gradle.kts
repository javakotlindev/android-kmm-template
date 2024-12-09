plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.serialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:common"))
            implementation(project(":shared:common-ui"))
            implementation(project(":shared:domain"))
            implementation(project(":shared:features:auth"))
            implementation(project(":shared:features:main"))
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.features.root"
    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    implementation(project(":shared:common-ui"))
}
