package me.nickellis.kmmsample.shared

import co.touchlab.kermit.Logger

expect class Platform() {
    val platform: String
    val logger: Logger
}