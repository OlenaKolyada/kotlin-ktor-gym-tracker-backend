plugins {
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.ktor) apply false
    alias(libs.plugins.kotlin.plugin.serialization) apply false
}

group = "com.funkycorgi.funkytap"
version = "0.0.1"

subprojects {
    group = rootProject.group
    version = rootProject.version
}

ext {
    val specDir = layout.projectDirectory.dir("specs")
    set("spec-funkytap-api", specDir.file("spec-funkytap-api.yaml").toString())
}