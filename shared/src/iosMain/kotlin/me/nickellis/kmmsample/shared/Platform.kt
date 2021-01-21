package me.nickellis.kmmsample.shared


import co.touchlab.kermit.Kermit
import co.touchlab.kermit.NSLogLogger
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    actual val logger: Kermit = Kermit(NSLogLogger())
}