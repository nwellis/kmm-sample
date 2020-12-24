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

package me.nickellis.kmmsample.androidApp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import org.koin.core.KoinComponent

abstract class BaseFragment : Fragment(), KoinComponent {

    @LayoutRes
    open val layoutId: Int? = null

    /**
     * Called after [onCreateView], setup views here.
     */
    open fun setupViews() {}

    /**
     * Called after [onCreateView] and [setupViews], once views are setup we can subscribe to
     * our observables and act upon our views.
     */
    open fun subscribeToObservables() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        layoutId ?: error("Must override onCreateView or layoutId"),
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        subscribeToObservables()
    }
}