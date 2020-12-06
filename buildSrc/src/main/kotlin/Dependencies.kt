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

object AndroidSdk {
    const val min = 24
    const val compile = 29
    const val target = compile
}

object Kotlin {
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutines}"
    val coreSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.kotlinxSerialization}"
}

object Deps {
    const val kermit = "co.touchlab:kermit:${Versions.kermit}"
}

object Test {
    const val junit = "junit:junit:${Versions.junit}"
}

object Koin {
    val core = "org.koin:koin-core:${Versions.koin}"
    val android = "org.koin:koin-android:${Versions.koin}"
    val androidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
}

object Ktor {
    val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
    val clientJson = "io.ktor:ktor-client-json:${Versions.ktor}"
    val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
    val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"

    val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
    val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
}

object SqlDelight {
    val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    val coroutineExtensions = "com.squareup.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
    val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
}

object AndroidX {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
}

object Jetpack {
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.jetpackLifecycle}"
    val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetpackLifecycle}"
    val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetpackLifecycle}"
}

object UI {
    val materialUI = "com.google.android.material:material:${Versions.materialUi}"
    val constrainLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

