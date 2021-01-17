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

/**
 * Versions for various dependencies
 *
 * @see <a href="https://medium.com/better-programming/gradle-dependency-management-with-buildsrc-and-kotlin-dsl-1de958eab166">Medium Article</a>
 * @see <a href="https://github.com/PicPay/version-checker-gradle-lint>Version check linter</a>
 */
object Versions {
    const val kotlin = "1.4.21"
    const val kotlinCoroutines = "1.4.2-native-mt"
    const val ktor = "1.5.0"
    const val kotlinxSerialization = "1.0.0-RC"
    const val koin = "3.0.0-alpha-4"
    const val sqlDelight = "1.4.4"
    const val kermit = "0.1.8"

    const val junit = "4.13.1"
    const val testRunner = "1.3.0"

    //region Android
    const val axAppCompat = "1.2.0"
    const val axLegacySupport = "1.0.0"
    const val materialUi = "1.2.1"
    const val constraintLayout = "2.0.4"
    const val jetpackLifecycle = "2.2.0"
    const val jetpackNavigation = "2.3.2"
    const val viewBindingDelegate = "1.3.1"
    //endregion
}