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

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.get
import io.ktor.http.*
import kotlinx.serialization.json.Json
import me.nickellis.kmmsample.BuildKonfig
import me.nickellis.kmmsample.shared.ktx.RepoPreviewJson
import me.nickellis.kmmsample.shared.network.github.repos.Repo
import org.koin.core.KoinComponent
import org.koin.core.inject

class GitHubApi : KoinComponent {

    private val platformLogger: co.touchlab.kermit.Logger by inject()

    companion object {
        private const val baseUrl = "https://api.github.com"
        val username = BuildKonfig.OAUTH_GITHUB_USERNAME
    }

    private val nonStrictJson = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val client by lazy {
        HttpClient {
            defaultRequest {
                userAgent("me.nickellis.kmmsample/1.0")
            }

            install(Auth) { providers.add(GitHubAuthProvider) }
            install(JsonFeature) { serializer = KotlinxSerializer(nonStrictJson) }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        platformLogger.v(message = message, tag = "GitHub API")
                    }
                }
                level = LogLevel.ALL
            }
        }
    }

    init {
    }

    /**
     * Gets the repositories of the currently authenticated user.
     *
     * @param page Page index, 0 indexed
     * @param pageSize Number of repositories to return
     *
     * @see <a href="https://docs.github.com/en/free-pro-team@latest/rest/reference/repos#list-repositories-for-the-authenticated-user"></a>
     */
    suspend fun getRepos(page: Int = 0, pageSize: Int = 20) = client.get<List<Repo>> {
        accept(ContentType.Application.RepoPreviewJson)
        url {
            takeFrom("$baseUrl/user/repos")
            parameter("page", page)
            parameter("page_size", pageSize)
            platformLogger.d("${headers.build()}", "TESTING")
        }
    }
}