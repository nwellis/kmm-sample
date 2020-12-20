package me.nickellis.kmmsample.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import me.nickellis.kmmsample.shared.network.github.GitHubApi
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivity : AppCompatActivity(), KoinComponent {

    private val gitHubApi: GitHubApi by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        lifecycleScope.launchWhenResumed {
            tv.text = "Loading..."
            runCatching {
                tv.text = gitHubApi.getRepos().firstOrNull()?.url ?: "NO REPOS FOUND"
            }.getOrElse {
                tv.text = "ERROR: ${it.message}"
            }
        }
    }
}
