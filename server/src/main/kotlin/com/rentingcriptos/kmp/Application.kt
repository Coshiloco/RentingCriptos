package com.rentingcriptos.kmp

import SERVER_PORT
import com.rentingcriptos.kmp.plugins.configureRouting
import com.rentingcriptos.kmp.plugins.configureSecurity
import com.rentingcriptos.kmp.plugins.configureSerialization
import com.rentingcriptos.kmp.plugins.getJwtConfig
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val jwtConfig = getJwtConfig()
    configureSerialization()
    configureSecurity(jwtConfig)
    configureRouting(jwtConfig)
}
