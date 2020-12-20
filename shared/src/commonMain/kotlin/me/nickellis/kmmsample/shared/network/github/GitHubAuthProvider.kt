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

import io.ktor.client.features.auth.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.auth.*
import me.nickellis.kmmsample.BuildKonfig
import me.nickellis.kmmsample.shared.ktx.encodeBase64

object GitHubAuthProvider : AuthProvider {
    override val sendWithoutRequest: Boolean = true
    override fun isApplicable(auth: HttpAuthHeader) = true

    override suspend fun addRequestHeaders(request: HttpRequestBuilder) {
        val authValue = with(BuildKonfig) { "$OAUTH_GITHUB_USERNAME:$OAUTH_GITHUB_PASSWORD" }
        request.header(HttpHeaders.Authorization, "Basic ${authValue.encodeBase64()}")
    }
}