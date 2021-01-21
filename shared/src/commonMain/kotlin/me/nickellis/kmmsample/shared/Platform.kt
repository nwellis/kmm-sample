package me.nickellis.kmmsample.shared

import co.touchlab.kermit.Kermit

expect class Platform() {
    val platform: String
    val logger: Kermit
}