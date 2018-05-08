package br.com.felipeacerbi.githubapi.repos.view

import android.os.Bundle
import br.com.felipeacerbi.githubapi.base.view.BaseListFragment
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.view.PullsActivity
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.view.adapter.ReposAdapter
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.utils.launchActivityWithExtras
import br.com.felipeacerbi.githubapi.utils.observe
import org.parceler.Parcels
import javax.inject.Inject

class ReposListFragment : BaseListFragment() {

    @Inject lateinit var reposViewModel: ReposViewModel
    @Inject lateinit var adapter: ReposAdapter

    private var page = 1

    override fun startObservers() {
        observe(reposViewModel.state, {
            when(it) {
                is State.ShowLoading -> { showLoading() }
                is State.ItemsLoaded<*> -> { onItemsLoaded(it.items.map { it as Repo }, true) }
                is State.ShowContent -> { showContent() }
                is State.ShowError -> { showError() }
            }
        })

        observe(adapter.getAction(), {
            when(it) {
                is Action.ClickRepo ->
                    launchActivityWithExtras<PullsActivity>(PullsActivity::class,
                        arrayOf(PullsActivity.EXTRA_REPO),
                        arrayOf(Parcels.wrap(it.repo)))
            }
        })
    }

    private fun onAction(action: Action) = reposViewModel.performAction(action)

    override fun request() {
        onAction(Action.FetchRepos(arguments?.getString(ARG_LANGUAGE)?: "", page++))
    }

    override fun isInfinite() = true

    override fun showRefreshed() {
        page = 1
        super.showRefreshed()
    }

    override fun getAdapter(): BaseListAdapter = adapter

    companion object {

        private const val ARG_LANGUAGE = "language"

        fun newInstance(language: String): ReposListFragment {
            val fragment = ReposListFragment()
            val args = Bundle()
            args.putString(ARG_LANGUAGE, language)
            fragment.arguments = args
            return fragment
        }
    }
}
