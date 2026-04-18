plugins {
    id("build-jvm")
}

dependencies {
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.postgresql)
    implementation(libs.h2)
    implementation(libs.firebase.auth.provider)
}