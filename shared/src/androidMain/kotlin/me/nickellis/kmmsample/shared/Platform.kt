package me.nickellis.kmmsample.shared

import co.touchlab.kermit.Kermit
import co.touchlab.kermit.LogcatLogger

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    actual val logger: Kermit = Kermit(LogcatLogger())
}