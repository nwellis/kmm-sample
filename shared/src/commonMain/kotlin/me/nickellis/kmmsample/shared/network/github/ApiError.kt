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

package me.nickellis.kmmsample.shared.network.github

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * HTTP error response body returned by GitHub
 * @see <a href="https://docs.github.com/en/free-pro-team@latest/rest/overview/resources-in-the-rest-api#client-errors>GitHub Client Errors</a>
 */
@Serializable
data class ApiError(
    @SerialName("message") val message: String,
    @SerialName("error") val errors: List<ApiErrorCode> = emptyList()
)

@Serializable
data class ApiErrorCode(
    @SerialName("resource") val resource: String,
    @SerialName("field") val field: String,
    @SerialName("code") val code: String
)