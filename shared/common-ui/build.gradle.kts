plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    sourceSets {
        androidMain.dependencies {
            api(compose.preview)
            api(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            api(project(":shared:common"))
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(libs.androidx.lifecycle.runtime.compose)
            api(libs.bundles.decompose)
        }
    }
}

android {
    namespace = "com.ecosystem.monoraise.common.ui"
    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

compose.resources {
    publicResClass = true
    packageOfResClass = "com.ecosystem.monoraise.common.ui"
    generateResClass = always
}

dependencies {
    api(compose.uiTooling)
}
