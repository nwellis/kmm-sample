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

object AndroidLibs {
    // AndroidX
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    // UI
    val materialUI = "com.google.android.material:material:${Versions.materialUi}"
    val constrainLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // Koin
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // Jetpack
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.jetpackLifecycle}"
    val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetpackLifecycle}"
    val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetpackLifecycle}"
}