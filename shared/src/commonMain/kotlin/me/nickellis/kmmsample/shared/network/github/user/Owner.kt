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

package me.nickellis.kmmsample.shared.network.github.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    @SerialName("login") val login: String,
    @SerialName("id") val id: Long,
    @SerialName("type") val type: String,
    @SerialName("url") val url: String,
    @SerialName("site_admin") val isSiteAdmin: Boolean,
    @SerialName("html_url") val htmlUrl: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("gists_url") val gistsUrl: String,
    @SerialName("repos_url") val reposUrl: String,
)