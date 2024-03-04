package com.rentingcriptos.kmp.auth


import com.rentingcriptos.kmp.auth.models.RegisterRequest
import com.rentingcriptos.kmp.auth.models.User
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.usersRoute() {
    authenticate("auth-jwt") {
        get("/users") {
            // Aquí iría la lógica para obtener la lista de usuarios
            call.respond(HttpStatusCode.OK, listOfUsers)
        }

        post("/users") {
            val registerRequest = call.receive<RegisterRequest>()
            // Aquí iría la lógica para registrar un nuevo usuario
            call.respond(HttpStatusCode.Created)
        }

        get("/users/{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            // Aquí iría la lógica para obtener un usuario específico
            call.respond(HttpStatusCode.OK, user)
        }

        put("/users/{id}") {
            val id = call.parameters["id"] ?: return@put call.respond(HttpStatusCode.BadRequest)
            val user = call.receive<User>()
            // Aquí iría la lógica para actualizar un usuario específico
            call.respond(HttpStatusCode.OK)
        }

        delete("/users/{id}") {
            val id = call.parameters["id"] ?: return@delete call.respond(HttpStatusCode.BadRequest)
            // Aquí iría la lógica para eliminar un usuario específico
            call.respond(HttpStatusCode.OK)
        }
    }
}