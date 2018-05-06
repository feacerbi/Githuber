package br.com.felipeacerbi.githubapi.pulls.view

import android.os.Bundle
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.BaseActivity
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.view.adapter.PullsAdapter
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action.FetchPulls
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.utils.observe
import org.parceler.Parcels
import javax.inject.Inject

class PullsActivity(override val layoutResourceId: Int = R.layout.activity_main) : BaseActivity() {

    @Inject lateinit var pullsViewModel: PullsViewModel
    @Inject lateinit var pullsAdapter: PullsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getExtras()
        startObservers()

        val repo = getExtras()
        if(repo != null) {
            onAction(FetchPulls(repo.authorUsername, repo.name))
        } else TODO("Show error")
    }

    private fun startObservers() {
        observe(pullsViewModel.state, {
            when(it) {
                is State.ShowLoading -> { TODO() }
                is State.ItemsLoaded<*> -> { pullsAdapter.addItems(it.items.map { it as Pull }) }
                is State.ShowContent -> { TODO() }
                is State.ShowError -> { TODO("Show error") }
            }
        })

        observe(pullsAdapter.getAction(), {
            when(it) {
                is Action.ClickPull -> TODO("Open URL")
            }
        })
    }

    private fun onAction(action: Action) = pullsViewModel.performAction(action)

    private fun getExtras(): Repo? = Parcels.unwrap(intent.extras?.getParcelable(EXTRA_REPO))

    companion object {
        const val EXTRA_REPO = "extra_repo"
    }
}
