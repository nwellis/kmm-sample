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

package me.nickellis.kmmsample.androidApp.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.nickellis.kmmsample.androidApp.ui.BaseViewModel
import me.nickellis.kmmsample.androidApp.util.Resource
import me.nickellis.kmmsample.androidApp.util.updateWith
import me.nickellis.kmmsample.shared.network.github.GitHubApi
import me.nickellis.kmmsample.shared.network.github.repos.Repo
import org.koin.core.inject

class ReposViewModel(val handle: SavedStateHandle) : BaseViewModel() {

    private val gitHubApi: GitHubApi by inject()

    private val _repos = MutableLiveData<Resource<List<Repo>>>()
    val repos: LiveData<Resource<List<Repo>>> = _repos

    override fun refresh(force: Boolean) {
        viewModelScope.launch {
            _repos.updateWith { gitHubApi.getRepos() }
        }
    }
}