import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.serialization) apply false
}

subprojects {
    plugins.applyBaseConfig(project)
    plugins.applyKotlinMultiplatformConfig(this)
}

fun BaseExtension.baseConfig() {
    compileSdkVersion(34)

    defaultConfig.apply {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = JavaVersion.VERSION_17.toString()
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_11
            targetCompatibility = JavaVersion.VERSION_11
        }
    }
}

fun PluginContainer.applyBaseConfig(project: Project) {
    whenPluginAdded {
        when (this) {
            is com.android.build.gradle.AppPlugin -> {
                project.extensions.getByType<com.android.build.gradle.AppExtension>().apply {
                    baseConfig()
                }
            }

            is com.android.build.gradle.LibraryPlugin -> {
                project.extensions.getByType<com.android.build.gradle.LibraryExtension>().apply {
                    baseConfig()
                }
            }
        }
    }
}

fun PluginContainer.applyKotlinMultiplatformConfig(project: Project) {
    whenPluginAdded {
        when (this) {
            is org.jetbrains.kotlin.gradle.plugin.KotlinMultiplatformPluginWrapper -> {
                // Ensure the Android plugin is applied before configuring Kotlin targets
                project.pluginManager.withPlugin("com.android.application") {
                    configureKotlinMultiplatformTargets(project)
                }
                project.pluginManager.withPlugin("com.android.library") {
                    configureKotlinMultiplatformTargets(project)
                }
            }
        }
    }
}

private fun configureKotlinMultiplatformTargets(project: Project) {
    val kotlinExtension = project.extensions.getByType<org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension>()
    kotlinExtension.apply {
        androidTarget {
            @OptIn(ExperimentalKotlinGradlePluginApi::class)
            compilerOptions {
                jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
            }
        }

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach { iosTarget ->
            iosTarget.binaries.framework {
                baseName = "ComposeApp"
                isStatic = true
            }
        }

        sourceSets.all {
            languageSettings.enableLanguageFeature("ExplicitBackingFields")
        }
    }
}

tasks {
    register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
}
