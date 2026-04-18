package com.funkycorgi

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSecurity()
    configureHTTP()
    configureSerialization()
    configureDatabases()
    configureFrameworks()
    configureRouting()
}
