package me.nickellis.kmmsample.shared


import co.touchlab.kermit.Logger
import co.touchlab.kermit.PlatformThrowableStringProvider
import co.touchlab.kermit.Severity
import platform.Foundation.NSLog
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    //actual val logger: Logger = NSLogLogger()
    actual val logger: Logger = object : Logger() {
        // TODO: Why cant I import NSLogLogger?
        override fun log(severity: Severity, message: String, tag: String, throwable: Throwable?) {
            NSLog("%s: (%s) %s", severity.name, tag, message)
            throwable?.let {
                val string = PlatformThrowableStringProvider().getThrowableString(it)
                NSLog("%s", string)
            }
        }
    }
}