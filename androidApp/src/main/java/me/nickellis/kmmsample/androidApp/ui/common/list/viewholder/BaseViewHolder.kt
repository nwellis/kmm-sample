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

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<in T : Any?>(
    parent: ViewGroup,
    @LayoutRes layoutId: Int,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
) {
    private val context: Context get() = itemView.context

    /**
     * Method to bind the item data to this view. You can optionally use the `isSelected` if you
     * have a selected view state or not.
     *
     * @param item piece of data that should be bound to the view holder
     * @param isSelected whether or not the item's current state is selected
     */
    abstract fun bindTo(item: T, isSelected: Boolean = false)
}