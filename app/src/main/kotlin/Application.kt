package com.funkycorgi

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.response.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Hello, FunkyTap!")
        }
    }
}