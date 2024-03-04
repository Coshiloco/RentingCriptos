package com.rentingcriptos.kmp.plugins


import SERVER_PORT
import com.rentingcriptos.kmp.auth.authRoutes
import com.rentingcriptos.kmp.auth.models.JwtConfig
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.configureRouting(jwtConfig: JwtConfig) {
    routing {
        get("/") {
            call.respondText("Listening on port $SERVER_PORT")
        }
        authRoutes(jwtConfig = jwtConfig)
    }
}
