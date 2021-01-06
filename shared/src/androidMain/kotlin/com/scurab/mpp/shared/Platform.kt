package com.scurab.mpp.shared

actual class Platform {
    actual fun name(): String = "Android ${android.os.Build.VERSION.SDK_INT}"
}