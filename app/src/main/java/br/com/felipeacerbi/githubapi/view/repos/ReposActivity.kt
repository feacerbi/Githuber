package br.com.felipeacerbi.githubapi.view.repos

import android.os.Bundle
import android.util.Log
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.view.base.BaseActivity
import br.com.felipeacerbi.githubapi.view.observe
import br.com.felipeacerbi.githubapi.viewmodel.base.BaseViewModel.State
import br.com.felipeacerbi.githubapi.viewmodel.repos.ReposViewModel
import br.com.felipeacerbi.githubapi.viewmodel.repos.ReposViewModel.Action
import javax.inject.Inject

class ReposActivity(override val layoutResourceId: Int = R.layout.activity_main) : BaseActivity() {

    @Inject lateinit var reposViewModel: ReposViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startObservers()
        onAction(Action.FetchRepos("language:java", 1))
    }

    private fun startObservers() = observe(reposViewModel.state, {
            when(it) {
                is State.ShowLoading -> { Log.d("Test", "Show Loading")}
                is State.ItemsLoaded<*> -> { Log.d("Test", "Items: " + it.items.size ) }
                is State.ShowContent -> { Log.d("Test", "Show Content") }
                is State.ShowError -> { Log.d("Test", "Show Error") }
            }
        })

        private fun onAction(action: Action) = reposViewModel.performAction(action)
}
