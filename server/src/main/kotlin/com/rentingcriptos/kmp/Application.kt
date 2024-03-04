package com.rentingcriptos.kmp

import com.rentingcriptos.kmp.plugins.configureRouting
import com.rentingcriptos.kmp.plugins.configureSecurity
import com.rentingcriptos.kmp.plugins.getJwtConfig
import io.ktor.server.application.Application
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
    val jwtConfig = getJwtConfig()
    configureSecurity(jwtConfig)
    configureRouting(jwtConfig)
}
