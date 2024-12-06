plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:common"))
            implementation(project(":shared:common-ui"))
            implementation(project(":shared:data-source:data"))
            implementation(project(":shared:data-source:remote"))
            implementation(project(":shared:data-source:local"))
            implementation(project(":shared:domain"))
            implementation(project(":shared:features:auth"))
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.ecosystem.monoraise"
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

}

dependencies {
    debugImplementation(compose.uiTooling)
}

