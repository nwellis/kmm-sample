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

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import me.nickellis.kmmsample.androidApp.R
import me.nickellis.kmmsample.androidApp.databinding.FragmentReposBinding
import me.nickellis.kmmsample.androidApp.ui.BaseFragment
import me.nickellis.kmmsample.androidApp.ui.common.list.ReposAdapter
import me.nickellis.kmmsample.androidApp.util.Resource
import me.nickellis.kmmsample.shared.network.github.repos.Repo
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple fragment to display the authorized user's [Repo]s in a list.
 */
class ReposFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_repos
    private val binding: FragmentReposBinding by viewBinding()
    private val viewModel: ReposViewModel by viewModel()

    private lateinit var reposAdapter: ReposAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reposAdapter = ReposAdapter()

        binding.reposRecycler.apply {
            adapter = reposAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.repos.observe(viewLifecycleOwner, {
            if (it is Resource.Success) reposAdapter.setRepos(it.data)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}