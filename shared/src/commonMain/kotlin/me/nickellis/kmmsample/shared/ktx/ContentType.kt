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

package me.nickellis.kmmsample.shared.ktx

import io.ktor.http.*

/**
 * <a href="https://docs.github.com/en/free-pro-team@latest/rest/reference/repos#list-organization-repositories-preview-notices">Repo Preview Features</a>
 */
val ContentType.Application.RepoPreviewJson: String
    get() = "application/vnd.github.nebula-preview+json"