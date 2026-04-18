rootProject.name = "funkytap"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

pluginManagement {
    includeBuild("build-plugin")
    plugins {
        id("build-jvm").apply(false)
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":http")
include(":infra")
include(":openapi")
include(":feature:analytics")
include(":feature:catalog")
include(":feature:workout")
include(":feature:user")
