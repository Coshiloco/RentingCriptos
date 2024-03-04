package com.rentingcriptos.kmp.auth

import com.rentingcriptos.kmp.auth.models.JwtConfig
import com.rentingcriptos.kmp.auth.models.LoginRequest
import com.rentingcriptos.kmp.auth.models.RegisterRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post

fun Route.authRoutes(jwtConfig: JwtConfig) {
    val authService = AuthService(jwtConfig)

    post("/login") {
        val loginRequest = call.receive<LoginRequest>()
        val user = authService.authenticate(loginRequest)
        if (user != null) {
            val token = authService.generateToken(user)
            call.respond(hashMapOf("token" to token))
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Invalid credentials")
        }
    }

    post("/register") {
        val registerRequest = call.receive<RegisterRequest>()
        val registered = authService.register(registerRequest)
        if (registered) {
            call.respond(HttpStatusCode.Created, "User created")
        } else {
            call.respond(HttpStatusCode.BadRequest, "User already exists")
        }
    }
}
