rootProject.name = "MonoRaise"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":monoraiseApp")

include(":shared:common")
include(":shared:common-ui")
include(":shared:domain")
include(":shared:data-source:data")
include(":shared:data-source:remote")
include(":shared:data-source:local")
include(":shared:features:auth")
include(":shared:features:root")
include(":shared:features:main")
