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

package me.nickellis.kmmsample.androidApp.util

import androidx.lifecycle.MutableLiveData

sealed class Resource<out T : Any> {
    object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Error(val error: Throwable) : Resource<Nothing>()
}


suspend fun <T : Any> MutableLiveData<Resource<T>>.updateWith(
    block: suspend () -> T
) = runCatching {
    value = Resource.Loading
    block()
}.onFailure {
    value = Resource.Error(it)
}.onSuccess {
    value = Resource.Success(it)
}.let { this }

fun <T : Any> MutableLiveData<Resource<T>>.ifError(
    block: () -> Unit
) = block.takeIf { value is Resource.Error }?.invoke()

fun <T : Any> MutableLiveData<Resource<T>>.ifSuccess(
    block: () -> Unit
) = block.takeIf { value is Resource.Success }?.invoke()