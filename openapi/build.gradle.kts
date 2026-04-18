plugins {
    id("build-jvm")
    alias(libs.plugins.openapi.generator)
}

sourceSets {
    main {
        kotlin.srcDir(layout.buildDirectory.dir("generated/src/main/kotlin"))
    }
}

openApiGenerate {
    val openapiGroup = "${rootProject.group}.api"
    generatorName.set("kotlin")
    packageName.set(openapiGroup)
    apiPackage.set("$openapiGroup.api")
    modelPackage.set("$openapiGroup.models")
    invokerPackage.set("$openapiGroup.invoker")
    inputSpec.set("${projectDir}/spec/spec-funkytap-api.yaml")
    outputDir.set(layout.buildDirectory.dir("generated").get().asFile.path)

    globalProperties.apply {
        put("models", "")
        put("modelDocs", "false")
    }

    configOptions.set(
        mapOf(
            "dateLibrary" to "string",
            "enumPropertyNaming" to "UPPERCASE",
            "serializationLibrary" to "kotlinx_serialization",
            "collectionType" to "list"
        )
    )
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks {
    compileKotlin {
        dependsOn(openApiGenerate)
    }
}