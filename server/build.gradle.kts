plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "com.rentingcriptos.kmp"
version = "1.0.0"
application {
    mainClass.set("com.rentingcriptos.kmp.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.auth)
    implementation(libs.ktor.server.auth.jwt)
    implementation(libs.ktor.server.auth.jvm)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.server.serialization)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}