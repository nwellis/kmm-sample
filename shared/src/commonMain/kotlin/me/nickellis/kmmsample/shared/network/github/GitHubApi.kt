/*
 *
 *  * Copyright (C) 2020 Nick Ellis
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package me.nickellis.kmmsample.shared.network.github

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.get
import io.ktor.http.*
import kotlinx.serialization.json.Json
import me.nickellis.kmmsample.BuildKonfig

class GitHubApi {
    companion object {
        private const val baseUrl = "https://api.github.com"
    }

    private val nonStrictJson = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    private val client by lazy {
        HttpClient {
            defaultRequest {
                header(HttpHeaders.UserAgent, "me.nickellis.kmmsample/1.0")
            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(nonStrictJson)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.INFO
            }
            install(Auth) {
                basic {
                    username = BuildKonfig.OAUTH_GITHUB_USERNAME
                    password = BuildKonfig.OAUTH_GITHUB_PASSWORD
                }
            }
        }
    }
}