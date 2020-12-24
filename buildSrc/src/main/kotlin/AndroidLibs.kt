import org.gradle.kotlin.dsl.extra

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
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //region AndroidX
    const val axAppCompat = "androidx.appcompat:appcompat:${Versions.axAppCompat}"
    const val axLegacySupport = "androidx.legacy:legacy-support-v4:${Versions.axLegacySupport}"
    //endregion

    //region UI
    const val materialUI = "com.google.android.material:material:${Versions.materialUi}"
    const val constrainLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    //endregion

    //region Koin
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinAndroidViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    //endregion

    //region Jetpack Lifecycle
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.jetpackLifecycle}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.jetpackLifecycle}"
    const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.jetpackLifecycle}"
    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.jetpackLifecycle}"
    //endregion

    //region Jetpack Navigation
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.jetpackNavigation}"
    const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.jetpackNavigation}"
    //endregion
}