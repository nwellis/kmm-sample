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

package me.nickellis.kmmsample.shared.network.github.repos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("full_name") val fullName: String,
    @SerialName("private") val isPrivate: Boolean,
    @SerialName("url") val url: String,
    @SerialName("stargazers_count") val starCount: Int,
    @SerialName("watchers_count") val watchCount: Int,
    @SerialName("subscribers_count") val subscribersCount: Int,
    @SerialName("topics") val topics: List<String> = emptyList(),
    @SerialName("default_branch") val defaultBranch: String,
    @SerialName("visibility") val visibility: String,
)