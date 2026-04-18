plugins {
    id("build-jvm")
}

dependencies {
    implementation(libs.kotlinx.datetime)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
}
