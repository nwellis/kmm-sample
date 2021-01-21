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

import com.squareup.sqldelight.db.SqlDriver
import me.nickellis.kmmsample.GitHubDatabase
import me.nickellis.kmmsample.shared.network.github.GitHubApi
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.get
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

open class GitHubSDK(
    private val sqlDriver: SqlDriver,
    private val appDeclaration: KoinAppDeclaration = {},
) : KoinComponent {
    companion object;

    private val platform = Platform()

    protected val api: GitHubApi get() = get()
    protected val database: GitHubDatabase get() = get()

    init {
        startKoin {
            appDeclaration()

            val commonModule = module {
                single { platform.logger }
                single { GitHubApi(get()) }
                single { GitHubDatabase(sqlDriver) }
            }

            modules(commonModule)
        }
    }
}