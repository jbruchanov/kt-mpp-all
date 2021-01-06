package com.scurab.mpp.shared

actual class Platform {
    actual fun name(): String = "JVM:${System.getProperty("java.version")}"
}