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

package me.nickellis.kmmsample.androidApp.ui.common.list.viewholder

import android.view.ViewGroup
import android.widget.TextView
import me.nickellis.kmmsample.androidApp.R
import me.nickellis.kmmsample.shared.network.github.repos.Repo

class RepoViewHolder(parent: ViewGroup) : BaseViewHolder<Repo>(
    parent = parent,
    layoutId = R.layout.vh_repo
) {
    override fun bindTo(item: Repo, isSelected: Boolean) {
        (itemView as? TextView)?.text = item.fullName
    }
}