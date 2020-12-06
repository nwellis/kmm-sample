/*
 * Copyright (C) 2020 Nick Ellis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Libs {
    // Kotlin
    val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    val kotlinCoreSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"

    // Logging
    val kermit = "co.touchlab:kermit:${Versions.kermit}"

    // Koin
    val koinCore = "org.koin:koin-core:${Versions.koin}"

    // Ktor
    val ktorClientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val ktorClientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val ktorClientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val ktorClientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    val ktorClientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val ktorClientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"

    // SQL Delight
    val sqlDelightRuntime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    val sqlDelightCoroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    val sqlDelightAndroidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    val sqlDelightNativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"

    // Test
    val junit = "junit:junit:${Versions.junit}"
}