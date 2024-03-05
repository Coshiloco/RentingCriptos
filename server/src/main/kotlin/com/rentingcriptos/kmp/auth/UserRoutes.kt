package com.rentingcriptos.kmp.auth


import io.ktor.server.auth.authenticate
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put

fun Route.usersRoute() {
    authenticate("auth-jwt") {
        get("/users") {

        }

        post("/users") {

        }

        get("/users/{id}") {

        }

        put("/users/{id}") {

        }

        delete("/users/{id}") {

        }
    }
}