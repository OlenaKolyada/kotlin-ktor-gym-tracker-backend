rootProject.name = "funkytap"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":feature:analytics")
include(":feature:catalog")
include(":feature:workout")
include(":feature:user")