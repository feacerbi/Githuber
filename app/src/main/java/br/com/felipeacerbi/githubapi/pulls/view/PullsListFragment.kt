package br.com.felipeacerbi.githubapi.pulls.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import br.com.felipeacerbi.githubapi.base.view.BaseListFragment
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.view.adapter.PullsAdapter
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.utils.observe
import org.parceler.Parcels
import javax.inject.Inject

class PullsListFragment : BaseListFragment() {

    @Inject lateinit var pullsViewModel: PullsViewModel
    @Inject lateinit var adapter: PullsAdapter

    private lateinit var repo: Repo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repo = Parcels.unwrap(arguments?.getParcelable(EXTRA_REPO))
    }

    override fun startObservers() {
        observe(pullsViewModel.state, {
            when(it) {
                is State.ShowLoading -> { showLoading() }
                is State.ItemsLoaded<*> -> { onItemsLoaded(it.items.map { it as Pull }) }
                is State.ShowContent -> { showContent() }
                is State.ShowError -> { showError() }
            }
        })

        observe(adapter.getAction(), {
            when(it) {
                is Action.ClickPull -> openBrowserUrl(it.pull.url ?: "")
            }
        })
    }

    private fun openBrowserUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

    private fun onAction(action: Action) = pullsViewModel.performAction(action)

    override fun request() {
        onAction(Action.FetchPulls(repo.authorUsername ?: "", repo.name ?: ""))
    }

    override fun getAdapter(): BaseListAdapter = adapter

    companion object {

        private const val EXTRA_REPO = "extra_repo"

        fun newInstance(repo: Repo?): PullsListFragment {
            val fragment = PullsListFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_REPO, Parcels.wrap(repo))
            fragment.arguments = args
            return fragment
        }
    }
}
