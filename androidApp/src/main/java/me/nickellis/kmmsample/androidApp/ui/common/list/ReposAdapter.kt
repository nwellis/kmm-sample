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

package me.nickellis.kmmsample.androidApp.ui.common.list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.nickellis.kmmsample.androidApp.ui.common.list.viewholder.RepoViewHolder
import me.nickellis.kmmsample.shared.network.github.repos.Repo

class ReposAdapter : RecyclerView.Adapter<RepoViewHolder>() {
    private val repos: List<Repo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bindTo(repos[position])
    }

    override fun getItemCount(): Int = repos.size
}