package com.rentingcriptos.kmp.plugins

import com.rentingcriptos.kmp.auth.models.JwtConfig
import io.ktor.server.application.Application


fun Application.getJwtConfig(): JwtConfig {
    val secret =
        environment.config.propertyOrNull("ktor.jwt.secret")?.getString() ?: "default_secret"
    val issuer = environment.config.property("ktor.jwt.issuer").getString()
    val audience = environment.config.property("ktor.jwt.audience").getString()
    val realm = environment.config.property("ktor.jwt.realm").getString()

    return JwtConfig(secret, issuer, audience, realm)
}