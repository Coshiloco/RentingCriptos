plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    kotlin("jvm") version libs.versions.kotlin.get()
    id("io.ktor.plugin") version libs.versions.ktor.get()
    id("org.jetbrains.kotlin.plugin.serialization") version libs.versions.kotlinSerialization.get()
    alias(libs.plugins.kotlinMultiplatform) apply false
}