package me.nickellis.kmmsample.shared

import co.touchlab.kermit.LogcatLogger
import co.touchlab.kermit.Logger

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    actual val logger: Logger = LogcatLogger()
}