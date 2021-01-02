package me.nickellis.kmmsample.shared


import co.touchlab.kermit.Logger
import co.touchlab.kermit.NSLogLogger
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion

    actual val logger: Logger = NSLogLogger()
}