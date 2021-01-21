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

import co.touchlab.kermit.Kermit
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import me.nickellis.kmmsample.shared.ktx.ensureNotFrozen
import me.nickellis.kmmsample.shared.ktx.isFrozen
import me.nickellis.kmmsample.shared.network.github.repos.Repo
import org.koin.core.KoinComponent
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
private const val Tag = "GitHubApi"

@ThreadLocal
private const val baseUrl = "https://api.github.com"

class GitHubApi(log: Kermit) : KoinComponent {

    init {
        ensureNotFrozen()
    }

    // If this is a constructor property, then it gets captured inside HttpClient config and freezes this whole class
    @Suppress("CanBePrimaryConstructorProperty")
    private val platformLogger = log

    private val client = HttpClient {
        defaultRequest {
            userAgent("me.nickellis.kmmsample/1.0")
        }

        install(Auth) { providers.add(GitHubAuthProvider()) }
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    //platformLogger.v(Tag) { message }
                }
            }
            level = LogLevel.ALL
        }
    }

    /**
     * Gets the repositories of the currently authenticated user.
     *
     * @param page Page index, 0 indexed
     * @param pageSize Number of repositories to return
     *
     * @see <a href="https://docs.github.com/en/free-pro-team@latest/rest/reference/repos#list-repositories-for-the-authenticated-user">list repos doc</a>
     */
    suspend fun getRepos(page: Int = 0, pageSize: Int = 20) = client.get<List<Repo>> {
        accept(ContentType.parse("application/vnd.github.nebula-preview+json"))
        url {
            takeFrom("$baseUrl/user/repos")
            parameter("page", page)
            parameter("page_size", pageSize)
        }
    }.also {
        val res = it.isFrozen
        platformLogger.d(Tag) { "FROZEN:$res ${client.isFrozen}" }
    }
}