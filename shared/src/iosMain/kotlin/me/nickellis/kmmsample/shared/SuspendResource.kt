/*
 * Copyright (C) 2021 Nick Ellis
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

package me.nickellis.kmmsample.shared

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.freeze

/**
 * Conversion of a suspend function to callback. See Touchlab article about implementation.
 *
 * @see <a href="https://dev.to/touchlab/working-with-kotlin-coroutines-and-rxswift-24fa>Touchlab Article</a>
 */
class SuspendResource<T>(private val suspender: suspend () -> T) {

    init { freeze() }

    private val scope: CoroutineScope = object : CoroutineScope {
        override val coroutineContext: CoroutineContext
            get() = SupervisorJob() + Dispatchers.Default
    }

    fun subscribe(
        onSuccess: (item: T) -> Unit,
        onError: (error: Throwable) -> Unit
    ): Job = scope.launch {
        try {
            onSuccess(suspender().freeze())
        } catch (error: Throwable) {
            onError(error.freeze())
        }
    }
}