package com.rentingcriptos.kmp.auth.models


data class LoginRequest(
    val username: String,
    val password: String
)


data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)