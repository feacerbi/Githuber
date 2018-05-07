package br.com.felipeacerbi.githubapi.pulls.view

import android.os.Bundle
import android.support.v7.widget.Toolbar
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.BaseActivity
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.utils.transact
import kotlinx.android.synthetic.main.activity_pulls.*
import org.parceler.Parcels

class PullsActivity(override val layoutResourceId: Int = R.layout.activity_pulls) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = getExtras()
        transact(PullsListFragment.newInstance(repo), R.id.fl_container)

        toolbar.setNavigationOnClickListener { onBackPressed() }
        toolbar.title = repo?.name
    }

    private fun getExtras(): Repo? = Parcels.unwrap(intent.extras?.getParcelable(EXTRA_REPO))

    override fun getToolbarView(): Toolbar?  = toolbar

    companion object {
        const val EXTRA_REPO = "extra_repo"
    }
}
