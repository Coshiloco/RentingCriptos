package com.rentingcriptos.kmp.plugins

import com.rentingcriptos.kmp.auth.models.JwtConfig
import io.ktor.server.application.Application


fun Application.getJwtConfig(): JwtConfig {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val myRealm = environment.config.property("jwt.realm").getString()
    return JwtConfig(secret, issuer, audience, myRealm)
}