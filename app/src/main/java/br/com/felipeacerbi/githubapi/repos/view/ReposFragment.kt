package br.com.felipeacerbi.githubapi.repos.view

import android.os.Bundle
import br.com.felipeacerbi.githubapi.base.viewmodel.BaseViewModel.State
import br.com.felipeacerbi.githubapi.pulls.view.PullsActivity
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.view.adapter.ReposAdapter
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.utils.launchActivityWithExtras
import br.com.felipeacerbi.githubapi.utils.observe
import dagger.android.support.DaggerFragment
import org.parceler.Parcels
import javax.inject.Inject

class ReposFragment : DaggerFragment() {

    @Inject lateinit var reposViewModel: ReposViewModel
    @Inject lateinit var adapter: ReposAdapter

    var page = 0

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObservers()
        onAction(Action.FetchRepos(arguments?.getString(ARG_LANGUAGE)?: "", page))
    }

    private fun startObservers() {
        observe(reposViewModel.state, {
            when (it) {
                is State.ShowLoading -> { TODO() }
                is State.ItemsLoaded<*> -> { adapter.addItems(it.items.map { it as Repo }) }
                is State.ShowContent -> { TODO() }
                is State.ShowError -> { TODO() }
            }
        })

        observe(adapter.getAction(), {
            when(it) {
                is Action.ClickRepo ->
                    launchActivityWithExtras<PullsActivity>(PullsActivity::class,
                        arrayOf(PullsActivity.EXTRA_REPO),
                        arrayOf(Parcels.wrap(it)))
            }
        })
    }

    private fun onAction(action: Action) = reposViewModel.performAction(action)

    companion object {

        private const val ARG_LANGUAGE = "language"

        fun newInstance(language: String): ReposFragment {
            val fragment = ReposFragment()
            val args = Bundle()
            args.putString(ARG_LANGUAGE, language)
            fragment.arguments = args
            return fragment
        }
    }
}
